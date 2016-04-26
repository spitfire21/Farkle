package edu.plu.cs.farkle.server.resource.game;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;

import edu.plu.cs.farkle.server.core.FarkleServerApplication;
import edu.plu.cs.farkle.server.resource.game.ai.AIPlayer;
import edu.plu.cs.farkle.server.resource.game.ai.AIRunner;

public class Game {
	// set size of game
	private int GAME_SIZE = 1;
	// current player rolling
	private Player currentPlayer;
	private int winningScore = 10000;
	// status of game
	private String status;
	// list of players
	private List<Player> players;
	// id of the game
	private int id;
	// AI Runner
	AIRunner ai;
	private Variation var;
	private String fourPlusKind;
	private int threshHold, threePair, straight, fullHouse, farkleDeduction;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	/**
	 * Constructor for the game, sets default settings (TODO expand settings)
	 * 
	 * @param id
	 */
	public Game(int id) {
		setStatus("WAITING");
		this.id = id;
		players = new ArrayList<Player>();
		ai = new AIRunner();
		fourPlusKind = "";
		threshHold = threePair = straight = fullHouse = farkleDeduction = 0;
	}

	/**
	 * Add player to game
	 * 
	 * @param p
	 * @throws IOException
	 */
	public void addPlayer(Player p) throws IOException {

		// check if game is over full
		if (players.size() > GAME_SIZE) {
			p.sendMessage("Error", "GAME IS FULL");
			return;
			// if game can hold people, then add player
		} else if (players.size() < GAME_SIZE) {
			players.add(p);
			for (int i = 0; i < players.size() - 1; i++) {
				players.get(i).sendMessage("Status Waiting", p.id + " connected to the game");
			}

		}
		// if game is now full then start
		if (players.size() == GAME_SIZE) {
			setStatus("FULL");

			start();
		}

	}

	public int getNumberOfPlayers() {
		return players.size();
	}

	/**
	 * Start game for players
	 * 
	 * @throws IOException
	 */
	private void start() {
		if (GAME_SIZE == 1) {
			ai.addPlayer(new AIPlayer(1, "AI1", this));

			ai.addPlayer(new AIPlayer(2, "AI2", this));
			ai.addPlayer(new AIPlayer(10, "AI3", this));
			for (int i = 0; i < 3; i++) {
				for (int y = 0; y < players.size(); y++) {

					players.get(y).sendMessage("Status Waiting",
							ai.getPlayers().get(i).getName() + " connected to the game");
				}
			}

		}
		// set first player to roll
		currentPlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			players.get(i).opponents.addAll(players);
			players.get(i).opponents.remove(players.get(i).getPlayerNumber());
			players.get(i).start();

		}
		System.out.println(players.size());

		checkPlayers();
	}

	/**
	 * get ID
	 * 
	 * @return
	 */
	public int getID() {
		return id;
	}

	/**
	 * Get Status
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set Status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Check if dice roll is a farkle
	 * 
	 * @param dice
	 * @return
	 */
	public boolean checkFarkle(List<Integer> dice) {
		if (dice.contains(1)) {
			return false;
		} else if (Collections.frequency(dice, 1) >= 3) {
			return false;
		} else if (Collections.frequency(dice, 2) >= 3) {
			return false;
		} else if (Collections.frequency(dice, 3) >= 3) {
			return false;
		} else if (Collections.frequency(dice, 4) >= 3) {
			return false;
		} else if (Collections.frequency(dice, 5) >= 3) {
			return false;
		} else if (Collections.frequency(dice, 6) >= 3) {
			return false;
		} else if (dice.contains(5)) {
			return false;
		} else if (threePair > 0 && checkScore(dice)>0){
			return false;
		}
		return true;

	}


	/**
	 * Check if player can roll
	 * 
	 * @param player
	 * @return
	 */
	private boolean canRoll(Player player) {
		// if player has stored dice and is current player
		if (player.stored && currentPlayer == player)
			return true;

		return false;

	}

	// end players turn
	private void endTurn(Player player) {
		if (player.score < winningScore) {

			// set storedScore as 0
			player.storedScore = 0;
			// remove dice
			player.dice.removeAll(player.dice);
			// remove storedDice
			player.storedDice.removeAll(player.storedDice);
			// send message to player
			// player.sendMessage("Status Waiting", "WAIT YOUR TURN");
			// set player as stored
			player.stored = true;
			// if last player in list then rotate to first
			if (player.opponents.size() == player.getPlayerNumber()) {
				String aiStatus = ai.runAI();
				if (aiStatus.equals("")) {
					currentPlayer = players.get(0);
				} else {
					for (int i = 0; i < players.size(); i++) {
						players.get(i).sendMessage("GAME", aiStatus + " WON!");
					}
				}
			} else {
				// move to next player

				// System.out.println(currentPlayer.getPlayerNumber() + " "
				// +players.size() + " " +player.opponents.size());
				currentPlayer = player.opponents.get(player.getPlayerNumber());
			}
			// send message to player
			currentPlayer.sendMessage("Status Rolling", "It is now your turn, please roll");
		} else {
			player.stored = true;
			currentPlayer = null;
			FarkleServerApplication.getDatabase().updateVictories(player.id);

		}
	}

	/**
	 * Checks score by creating a hash map and checking frequency.
	 * 
	 * @param storedDice
	 * @return
	 */
	public int checkScore(List<Integer> storedDice) {
		int score = 0;
		boolean checked;
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 6; i++) {
			counter.put(i, 0);
		}
		for (int i = 0; i < storedDice.size(); i++) {

			int temp = counter.get(storedDice.get(i));
			temp++;
			counter.replace(storedDice.get(i), temp);
			storedDice.set(i, 0);
			System.out.println("num of dice: " + temp);

		}
		if (threePair > 0) {
			if ((score = var.ThreePair(counter)) > 0) {
				return score;
			}
		}
		if (!fourPlusKind.equals("none"))
			score = var.checkAll(counter);
		if (score == 0 && fullHouse > 0) {

			score = var.FullHouse(counter);

		}

		if (score == 0) {
			for(int i = 1; i <= 6; i++){
				if(i != 1 && i != 5){
					if(counter.get(i)!=3 && counter.get(i)!=0){
						return 0;
					}
				}
				
			}
			if (counter.get(1) == 3) {
				score += 1000;
			} else if (counter.get(1) >= 3) {
				score += 1000;
				score += counter.get(1) * 100 - 300;
			} else {
				score += counter.get(1) * 100;
			}
			if (counter.get(2) == 3) {
				score += 200;
			}
			if (counter.get(3) == 3) {
				score += 300;
			}
			if (counter.get(4) == 3) {
				score += 400;
			}
			if (counter.get(5) == 3) {
				score += 500;
			} else if (counter.get(5) >= 3) {
				score += 500;
				score += counter.get(5) * 50 - 150;
			} else {
				score += counter.get(5) * 50;
			}
			if (counter.get(6) == 3) {
				score += 600;
			}
		}
		
		return score;

	}

	public int getWinningScore() {
		return winningScore;
	}

	public void checkPlayers() {
		final Runnable check = new Runnable() {
			public void run() {

				for (int i = 0; i < players.size(); i++) {
					Player temp = players.get(i);
					if (!temp.checkAlive()) {
						if (currentPlayer.equals(temp)) {

							endTurn(temp);
						}
						players.remove(temp);
						for (int y = 0; y < players.size(); y++) {

							players.get(y).setPlayerNumber(y);
							players.get(y).opponents = players;
							players.get(y).opponents.remove(players.get(y).getPlayerNumber());
						}

					}

				}

			}
		};
		final ScheduledFuture<?> checkHandle = scheduler.scheduleAtFixedRate(check, 10, 10, SECONDS);
		scheduler.schedule(new Runnable() {
			public void run() {
				checkHandle.cancel(true);
			}
		}, 60 * 60, SECONDS);
	}

	/**
	 * Player class currently nested in game will be broken up
	 * 
	 * @author Cody-Desktop
	 *
	 */
	class Player {
		// opponent list
		private List<Player> opponents;
		private String id;
		private int playerNumber, score, storedScore;
		private boolean stored;
		// endpoint for sending message to client
		private RemoteEndpoint output;
		private Session session;
		// dice and stored dice arrays
		private List<Integer> dice;
		private List<Integer> storedDice;
		private boolean tFlag;
		private int farkleCounter;

		/**
		 * Default constructor for player
		 * 
		 * @param session
		 */
		public Player(Session session, String id) {
			// increment numOfOnline players
			playerNumber = getNumberOfPlayers();
			this.id = id;
			// set endpoint
			output = session.getRemote();
			this.session = session;
			opponents = new ArrayList<Player>();
			dice = new ArrayList<Integer>();
			storedDice = new ArrayList<Integer>();
			// set player so that they can roll when it is their turn
			stored = true;
			tFlag = false;
			// send start up message
			sendMessage("Status Waiting", "WELCOME " + id);
			sendMessage("Status Waiting", "YOU ARE PLAYER #" + playerNumber);
			sendMessage("Status Waiting", "MESSAGE Waiting for opponent to connect");

		}

		/**
		 * add opponent
		 * 
		 * @param opponent
		 */
		private void addOpponent(Player opponent) {
			opponents.add(opponent);
		}

		/**
		 * get player number
		 * 
		 * @return playerNumber
		 */
		private int getPlayerNumber() {
			return playerNumber;
		}

		/**
		 * set player number
		 * 
		 * @return playerNumber
		 */
		private void setPlayerNumber(int playerNumber) {
			this.playerNumber = playerNumber;
		}

		/**
		 * Start game for player
		 */
		private void start() {
			// send start message
			sendMessage("Status Waiting", "MESSAGE All players connected");

			// player is first player to join, they roll first
			if (getPlayerNumber() == 0)
				sendMessage("Status Rolling", "It is your turn to roll");
		}

		public void test(String command) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				ServerCommand cmd = mapper.readValue(command, ServerCommand.class);
				checkCommand(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/**
		 * Check command client sent to server
		 * 
		 * @param command
		 */
		public void checkCommand(ServerCommand cmd) {
			String command = cmd.getCommand();
			List<Integer> tempDice = new ArrayList<Integer>();
			tempDice.addAll(dice);
			System.out.println(command);
			// if command is ROLL and can roll generate numbers
			if (command.startsWith("ROLL") && canRoll(this)) {
				stored = false;
				// fill array with numbers
				// TODO use DICE class

				for (int i = storedDice.size(); i < 6; i++) {
					int roll = ThreadLocalRandom.current().nextInt(1, 7);
					dice.add(roll);

					// sendMessage(Integer.toString(roll));
				}
				while (dice.size() < 6) {
					dice.add(0);
				}

				sendJSON("ROLL", this.id, "Success", new Dice(dice), this.score, this.storedScore);
				// check for farkle
				
				if (checkFarkle(dice) == true) {
					if(farkleCounter == 3){
						farkleCounter = 0;
						score -= farkleDeduction;
					}else{
						farkleCounter += 1;
					}
					sendMessage("Farkle", "Wait you Turn");
					endTurn(this);
				}
			} else {
				for (int i = 0; i < players.size(); i++) {

					players.get(i).sendJSON("ROLL", this.id, "Success", new Dice(dice), this.score, this.storedScore);
				}

				// if command is STORE
			}
			STORE: if (command.startsWith("STORE") && currentPlayer == this) {
				int numOfDice = 0;
				System.out.println(tempDice);

				ArrayList<Integer> sentDice = (ArrayList<Integer>) cmd.getDice().getDice();
				// check if dice is not 0
				if (dice.size() > 0) {

					// if nothing was selected to score produce error
					if (sentDice.size() == 0) {
						sendMessage("Error", "You must store something");
					} else {
						// go through split and check for valid numbers
						for (int i = 0; i < sentDice.size(); i++) {
							if (dice.contains(sentDice.get(i)) && sentDice.get(i) != 0) {
								storedDice.add(sentDice.get(i));
								System.out.println(sentDice.get(i));
								dice.remove((Integer) sentDice.get(i));
								numOfDice += 1;

							} else if (Integer.valueOf(sentDice.get(i)) == 0) {

							} else {
								// invalid
								sendMessage("Error", "INVALID STORE WRITE NUMBERS AGAIN");
								// remove added dice
								for (int x = 0; x < numOfDice; x++) {
									storedDice.remove(storedDice.size() - 1);
								}
								// break to store label
								dice = tempDice;
								break STORE;
							}

						}
						ArrayList<Integer> temp = new ArrayList();
						temp.addAll(storedDice);
						// check if store hand has non scoring die
						if (checkScore(temp) == 0) {
							sendMessage("Error", "You can't store non-scoring die");
							for (int x = 0; x < numOfDice; x++) {
								// remove dice
								storedDice.remove(storedDice.size() - 1);
							}
							// break to STORE label
							dice = tempDice;
							break STORE;
						}
						// remove all dice
						dice.removeAll(dice);
						for (int i = 0; i < players.size(); i++) {
							if (!players.get(i).id.equals(id))
								players.get(i).sendJSON("STORE", this.id, "Success", cmd.getDice(), this.score,
										this.storedScore);
						}
						// calculate score
						storedScore += checkScore(storedDice);
						// send stored dice to players

						// tell all players what score they could get
						for (int i = 0; i < players.size(); i++) {
							players.get(i).sendJSON("STORE", this.id, "Success", new Dice(dice), this.score,
									this.storedScore);
						}
						// reset roll
						stored = true;

						// reset roll if player gets 6 stored dice
						if (storedDice.size() == 6) {
							storedDice.removeAll(storedDice);
							dice.removeAll(dice);
						}
					}
				}

			}
			// score players hand
			if (command.startsWith("SCORE") && currentPlayer == this) {
				score += checkScore(dice);
				score += storedScore;
				if(score >= threshHold && tFlag == false){
					
				tFlag = true;
				}
				else if (tFlag == false){
				score = 0;	
				}
				
				storedScore = 0;
				farkleCounter = 0;
				sendJSON("SCORE", this.id, "Success", new Dice(dice), this.score, this.storedScore);
				endTurn(this);
			}
			if (command.startsWith("SETTINGS") && currentPlayer.id.equals(cmd.getName())) {
				String[] parts = cmd.getMessage().split(",");
				winningScore = Integer.parseInt(parts[0]);
				threshHold = Integer.parseInt(parts[1]);
				threePair = Integer.parseInt(parts[2]);
				fourPlusKind = parts[3];
				straight = Integer.parseInt(parts[4]);
				fullHouse = Integer.parseInt(parts[5]);
				farkleDeduction = Integer.parseInt(parts[6]);
				
				var = new Variation(straight, threePair, fullHouse, fourPlusKind);
			}

		}

		private boolean checkAlive() {
			if (session.isOpen())
				return true;
			else
				return false;

		}

		/**
		 * Send string to client TODO JSON
		 * 
		 * @param message
		 */
		private void sendMessage(String command, String message) {
			sendJSON(command, this.id, message, new Dice(this.dice), this.score, this.storedScore);

		}

		public void sendJSON(String command, String name, String message, Dice dice, int score, int storedScore) {
			ServerCommand cmd = new ServerCommand(command, name, message, dice, score, storedScore);
			ObjectMapper mapper = new ObjectMapper();

			try {
				output.sendString(mapper.writeValueAsString(cmd));
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
