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

import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;

import edu.plu.cs.farkle.server.core.FarkleServerApplication;
import edu.plu.cs.farkle.server.resource.game.ai.AIPlayer;
import edu.plu.cs.farkle.server.resource.game.ai.AIRunner;
import edu.plu.cs.farkle.server.resource.game.player.HumanPlayer;
import edu.plu.cs.farkle.server.resource.game.player.Player;
import edu.plu.cs.farkle.server.resource.game.scoring.CheckFourPlusStrategy;
import edu.plu.cs.farkle.server.resource.game.scoring.DefaultScoreStrategy;
import edu.plu.cs.farkle.server.resource.game.scoring.FullHouseScoreStrategy;
import edu.plu.cs.farkle.server.resource.game.scoring.Scoring;
import edu.plu.cs.farkle.server.resource.game.scoring.StraightScoreVariation;
import edu.plu.cs.farkle.server.resource.game.scoring.ThreePairScoreStrategy;

public class Game {
	// set size of game
	private int GAME_SIZE = 1;
	// current player rolling
	private HumanPlayer currentPlayer;
	private int winningScore = 10000;
	// status of game
	private String status;
	// list of players
	private List<HumanPlayer> players;
	// id of the game
	private int id;
	// AI Runner
	AIRunner ai;

	private String fourPlusKind;
	private int threshHold, farkleDeduction;
	private Scoring scoring;
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private int settingCounter = 0;

	/**
	 * Constructor for the game, sets default settings
	 * 
	 * @param id
	 */
	public Game(int id, int gameSize) {
		setStatus("WAITING");
		this.id = id;
		players = new ArrayList<HumanPlayer>();
		ai = new AIRunner();
		fourPlusKind = "";
		setThreshHold(setFarkleDeduction(0));
		GAME_SIZE = gameSize;
		scoring = new Scoring();
	}

	/**
	 * Add player to game
	 * 
	 * @param p
	 * @throws IOException
	 */
	public void addPlayer(HumanPlayer p) throws IOException {

		// check if game is over full
		if (players.size() > GAME_SIZE) {
			p.sendMessage("Error", "GAME IS FULL");
			return;
			// if game can hold people, then add player
		} else if (players.size() < GAME_SIZE) {
			players.add(p);
			for (int i = 0; i < players.size() - 1; i++) {
				players.get(i).sendMessage("Status Waiting", p.getName() + " connected to the game");
			}

		}
		// if game is now full then start
		if (players.size() == GAME_SIZE) {
			setStatus("FULL");

			start();
		}
		if(players.size()==0){
			setCurrentPlayer(p);
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
			ai.addPlayer(new AIPlayer(4, "AI3", this));
			for (int i = 0; i < 3; i++) {
				for (int y = 0; y < players.size(); y++) {

					players.get(y).sendMessage("Status Waiting",
							ai.getPlayers().get(i).getName() + " connected to the game");
				}
			}

		}
		// set first player to roll
		setCurrentPlayer(players.get(0));
		for (int i = 0; i < players.size(); i++) {
			players.get(i).getOpponents().addAll(players);
			players.get(i).getOpponents().remove(players.get(i).getPlayerNumber());
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
		} else if (checkScore(dice)>0){
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
	public boolean canRoll(Player player) {
		// if player has stored dice and is current player
		if (player.isStored() && getCurrentPlayer() == player)
			return true;

		return false;

	}

	// end players turn
	public void endTurn(HumanPlayer player) {
		if (player.getTotalScore() < winningScore) {

			// set storedScore as 0
			player.setScore(0);
			// remove dice
			player.getDice().removeAll(player.getDice());
			// remove storedDice
			player.getStoredDice().removeAll(player.getStoredDice());
			// send message to player
			// player.sendMessage("Status Waiting", "WAIT YOUR TURN");
			// set player as stored
			player.setStored(true);
			
			// if last player in list then rotate to first
			if (player.getOpponents().size() == player.getPlayerNumber()) {
				
				String aiStatus = ai.runAI();
				if (aiStatus.equals("")) {
					setCurrentPlayer(players.get(0));
				} else {
					
						for(int i = 0; i < players.size(); i++)
						{
							players.get(i).sendMessage("WIN", aiStatus + " Wins the game!");
							setCurrentPlayer(null);
						}
					
				}
			} else {
				// move to next player

				// System.out.println(currentPlayer.getPlayerNumber() + " "
				// +players.size() + " " +player.opponents.size());
				setCurrentPlayer(player.getOpponents().get(player.getPlayerNumber()));
			}
			// send message to player
			getCurrentPlayer().sendMessage("Status Rolling", "It is now your turn, please roll");
		} else {
			player.setStored(true);
			setCurrentPlayer(null);
			FarkleServerApplication.getDatabase().updateVictories(player.getName());
			for(int i = 0; i < players.size(); i++)
			{
				players.get(i).sendMessage("WIN", player.getName() + " Wins the game!");
			}
		}
	}

	/**
	 * Checks score by creating a hash map and checking frequency.
	 * 
	 * @param storedDice
	 * @return
	 */
	public int checkScore(List<Integer> storedDice) {
		
		return scoring.checkScore(storedDice);

	}
	public HumanPlayer getPlayer(int i) {
		return players.get(i);
		
	}

	public int getWinningScore() {
		return winningScore;
	}

	public void checkPlayers() {
		final Runnable check = new Runnable() {
			public void run() {

//				for (int i = 0; i < players.size(); i++) {
//					Player temp = players.get(i);
//					if (!temp.checkAlive()) {
//						if (currentPlayer.equals(temp)) {
//
//							endTurn(temp);
//						}
//						players.remove(temp);
//						for (int y = 0; y < players.size(); y++) {
//
//							players.get(y).setPlayerNumber(y);
//							players.get(y).opponents = players;
//							players.get(y).opponents.remove(players.get(y).getPlayerNumber());
//						}
//
//					}
//
//				}

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
	 * Check command client sent to server
	 * TODO break into either more manageable methods
	 * @param command
	 */
	public void checkCommand(ServerCommand cmd) {
		String command = cmd.getCommand();
		
		System.out.println(command);
		// if command is ROLL and can roll generate numbers
		if (command.startsWith("ROLL") && currentPlayer.getName().equals(cmd.getName()) && canRoll(currentPlayer)) {
			currentPlayer.Roll();
		}
		if (command.startsWith("STORE") && currentPlayer.getName().equals(cmd.getName())) {
			currentPlayer.Store(cmd);
		}
		if (command.startsWith("SCORE") && currentPlayer.getName().equals(cmd.getName())) {
			currentPlayer.Score(cmd);
		}
		if (command.startsWith("SETTINGS") && settingCounter == 0) {
			settingCounter = 1;
			String[] parts = cmd.getMessage().split(",");
			winningScore = Integer.parseInt(parts[0]);
			setThreshHold(Integer.parseInt(parts[1]));
			int threePair = Integer.parseInt(parts[2]);
			fourPlusKind = parts[3];
			int straight = Integer.parseInt(parts[4]);
			int fullHouse = Integer.parseInt(parts[5]);
			farkleDeduction = Integer.parseInt(parts[6]);
			scoring.addScoreSet(new StraightScoreVariation(straight));
			scoring.addScoreSet(new ThreePairScoreStrategy(threePair));
			scoring.addScoreSet(new FullHouseScoreStrategy(fullHouse));
			scoring.addScoreSet(new CheckFourPlusStrategy(0,fourPlusKind));
			scoring.addScoreSet(new DefaultScoreStrategy(0));
		}

	}
	public int getFarkleDeduction() {
		return farkleDeduction;
	}

	public int setFarkleDeduction(int farkleDeduction) {
		this.farkleDeduction = farkleDeduction;
		return farkleDeduction;
	}

	public HumanPlayer getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(HumanPlayer currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getThreshHold() {
		return threshHold;
	}

	public void setThreshHold(int threshHold) {
		this.threshHold = threshHold;
	}

	

	
}
