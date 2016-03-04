package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;

public class Game {
	// set size of game
	private int GAME_SIZE = 3;
	// current player rolling
	private Player currentPlayer;
	
	// status of game
	private String status;
	// list of players
	private List<Player> players;
	// id of the game
	private int id;
	/**
	 * Constructor for the game, sets default settings (TODO expand settings)
	 * @param id
	 */
	public Game(int id) {
		setStatus("WAITING");
		this.id = id;
		players = new ArrayList<Player>();
	}
	/**
	 * Add player to game
	 * @param p
	 * @throws IOException
	 */
	public void addPlayer(Player p) throws IOException {
		
		// check if game is over full
		if (players.size() > GAME_SIZE) {
			p.sendMessage("GAME IS FULL");
			return;
			// if game can hold people, then add player
		} else if (players.size() < GAME_SIZE){
			players.add(p);
			
		}
		// if game is now full then start
		if (players.size() == GAME_SIZE) {
			setStatus("FULL");
			
			start();
		}
		
	}
	public int getNumberOfPlayers(){
		return players.size();
	}
    /**
     * Start game for players
     * @throws IOException
     */
	private void start(){
		// set first player to roll
		currentPlayer = players.get(0);
		for (int i = 0; i < players.size(); i++) {
			players.get(i).start();
		}
	}
	/**
	 * get ID
	 * @return
	 */
	public int getID() {
		return id;
	}
	/**
	 * Get Status
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * Set Status
	 * @param status
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * Check if dice roll is a farkle
	 * @param dice
	 * @return
	 */
	private boolean checkFarkle(List<Integer> dice) {
		if (dice.contains(1)) {
			return false;
		} else if (Collections.frequency(dice, 1) == 3) {
			return false;
		} else if (Collections.frequency(dice, 2) == 3) {
			return false;
		} else if (Collections.frequency(dice, 3) == 3) {
			return false;
		} else if (Collections.frequency(dice, 4) == 3) {
			return false;
		} else if (Collections.frequency(dice, 5) == 3) {
			return false;
		} else if (Collections.frequency(dice, 6) == 3) {
			return false;
		} else if (dice.contains(5)) {
			return false;
		}
		return true;

	}
	/**
	 * Check if player has non scoring die in hand
	 * @param dice
	 * @return
	 */
	private boolean checkStoreHand(List<Integer> dice) {
		boolean flag = false;
		if (dice.contains(1)) {
			flag = false;
		}  if (dice.contains(5)) {
			flag = false;
		} if (Collections.frequency(dice, 2) != 3 &&
				Collections.frequency(dice, 2) != 0) {
			flag = true;
		}  if (Collections.frequency(dice, 3) != 3 
				&& Collections.frequency(dice, 3) != 0) {
			flag = true;
		}  if ((Collections.frequency(dice, 4)) != 0  
				&& (Collections.frequency(dice, 4)) != 3 ) {
			flag = true;
		}  if (Collections.frequency(dice, 6) != 3 &&
				Collections.frequency(dice, 6) != 0 ) {
			flag = true;
		} 
		return flag;

	}
/**
 * Check if player can roll
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
	private void endTurn(Player player){
		// set storedScore as 0
		player.storedScore = 0;
		// remove dice
		player.dice.removeAll(player.dice);
		// remove storedDice
		player.storedDice.removeAll(player.storedDice);
		// send message to player
		player.sendMessage("WAIT YOUR TURN");
		// set player as stored
		player.stored = true;
		// if last player in list then rotate to first
		if (getNumberOfPlayers() - 1 == player.getPlayerNumber()) {
			currentPlayer = player.opponents.get(0);
		} else {
			// move to next player
			currentPlayer = player.opponents.get(player.getPlayerNumber());
		}
		// send message to player
		currentPlayer.sendMessage("It is now your turn, please roll");

	}

	/**
	 * Really ugly needs to be redone
	 * 
	 * @param storedDice
	 * @return
	 */
	private int checkScore(List<Integer> storedDice) {
		int score = 0;
		int count = 0;
		while (storedDice.contains(1)) {
			storedDice.remove(Integer.valueOf(1));
			count++;
		}
		if (count == 3) {
			score += 1000;

		}

		else {
			score += count * 100;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		while (storedDice.contains(2)) {
			storedDice.remove(Integer.valueOf(2));
			count++;
		}
		if (count == 3) {
			score += 200;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		while (storedDice.contains(3)) {
			storedDice.remove(Integer.valueOf(3));
			count++;
		}
		if (count == 3) {
			score += 300;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		while (storedDice.contains(4)) {
			storedDice.remove(Integer.valueOf(4));
			count++;
		}
		if (count == 3) {
			score += 400;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		while (storedDice.contains(5)) {
			storedDice.remove(Integer.valueOf(5));
			count++;
		}
		if (count == 3) {
			score += 500;

		} else {
			score += count * 50;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		while (storedDice.contains(6)) {
			storedDice.remove(Integer.valueOf(6));
			count++;
		}
		if (count == 3) {
			score += 600;

		}
		for (int i = 0; i < count; i++) {
			storedDice.add(0);
		}
		count = 0;
		return score;

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
		private int playerNumber, score, storedScore;
		private boolean stored;
		// endpoint for sending message to client
		private RemoteEndpoint output;
		// dice and stored dice arrays
		private List<Integer> dice;
		private List<Integer> storedDice;
		/**
		 * Default constructor for player
		 * @param session
		 */
		public Player(Session session) {
			// increment numOfOnline players
			playerNumber = getNumberOfPlayers();
			// set endpoint
			output = session.getRemote();
			opponents = new ArrayList<Player>();
			dice = new ArrayList<Integer>();
			storedDice = new ArrayList<Integer>();
			// set player so that they can roll when it is their turn
			stored = true;

			
				// send start up message
				sendMessage("WELCOME PLAYER NUMBER " + playerNumber);
				sendMessage("MESSAGE Waiting for opponent to connect");
			

		}
		/**
		 * add opponent
		 * @param opponent
		 */
		private void addOpponent(Player opponent) {
			opponents.add(opponent);
		}
		/**
		 * get player number
		 * @return playerNumber
		 */
		private int getPlayerNumber() {
			return playerNumber;
		}
		/**
		 * Start game for player
		 */
		private void start() {
			//send start message
			sendMessage("MESSAGE All players connected");
			for (int i = 0; i < players.size(); i++) {
				for (int y = 0; y < players.size(); y++) {
					if (players.get(i).getPlayerNumber() != y) {
						// add other players as opponents
						players.get(i).addOpponent(players.get(y));
					}
				}
			}
			 
			// player is first player to join, they roll first
			if (getPlayerNumber() == 0)
				sendMessage("It is your turn to roll");
		}
		/**
		 * Check command client sent to server
		 * @param command
		 */
		public void checkCommand(String command){

			System.out.println(command);
			// if command is ROLL and can roll generate numbers
			if (command.startsWith("ROLL") && canRoll(this)) {
				stored = false;
				// fill array with numbers
				//TODO use DICE class
				for (int i = storedDice.size(); i < 6; i++) {
					int roll = ThreadLocalRandom.current().nextInt(1, 7);
					dice.add(roll);
					sendMessage(Integer.toString(roll));
				}
				// check for farkle
				if (checkFarkle(dice)) {
					sendMessage("FARKLE :(");
					endTurn(this);
				}
			}
			// if command is STORE
			STORE: if (command.startsWith("STORE ")) {
				int numOfDice = 0;
				// check if dice is not 0
				if (dice.size() > 0) {
					// split command
					String[] splits = command.split("[ ]");
					// if nothing was selected to score produce error
					  if (splits.length == 1) {
						sendMessage("You must store something");
					} else {
						// go through split and check for valid numbers
						for (int i = 1; i < splits.length; i++) {
							if (dice.contains(Integer.valueOf(splits[i]))) {
								storedDice.add(Integer.valueOf(splits[i]));
							} else {
								// invalid 
								sendMessage("INVALID STORE WRITE NUMBERS AGAIN");
								// remove added dice
								for(int x = 0; x < i; x++){
									storedDice.remove(storedDice.size()-1);
								}
								// break to store label
								break STORE;
							}
							// set numOfDice to i
							numOfDice = i;
						}
						// check if store hand has non scoring die
						if (checkStoreHand(storedDice)) {
							sendMessage("You can't store non-scoring die");
							for(int x = 0; x < numOfDice; x++){
								// remove dice
								storedDice.remove(storedDice.size()-1);
							}
							// break to STORE label
							break STORE;
						}
						// remove all dice
						dice.removeAll(dice);
						// calculate score
						storedScore += checkScore(storedDice);
						// tell player what score they could get
						sendMessage("Your current stored score is: " + storedScore);
						// reset roll
						stored = true;
						// reset roll if player gets 6 stored dice
						if (storedDice.size() == 6) {
							storedDice.removeAll(storedDice);
						}
					}
				}

			}
			// score players hand
			if (command.startsWith("SCORE")) {
				score += checkScore(dice);
				score += storedScore;
				sendMessage("YOUR CURRENT SCORE: " + score);
				endTurn(this);
			}

		}
		/**
		 * Send string to client TODO JSON
		 * @param message
		 */
		private void sendMessage(String message){
			
		try {
			output.sendString(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

	}
	
}
