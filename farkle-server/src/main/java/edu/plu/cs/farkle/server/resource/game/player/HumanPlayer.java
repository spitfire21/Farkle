package edu.plu.cs.farkle.server.resource.game.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;

import edu.plu.cs.farkle.server.resource.game.Dice;
import edu.plu.cs.farkle.server.resource.game.Game;
import edu.plu.cs.farkle.server.resource.game.ServerCommand;

/**
 * Player class currently nested in game 
 * 
 * @author Cody-Desktop
 *
 */

//opponent list
		
public class HumanPlayer extends Player {

	private int playerNumber;
	
	// endpoint for sending message to client
	private RemoteEndpoint output;
	private Session session;
	// dice and stored dice arrays
	
	private boolean tFlag;
	private int farkleCounter;
	
	private List<HumanPlayer> opponents;
	public HumanPlayer(Session session, String name, Game game) {
		super(name,game);
		// increment numOfOnline players
					playerNumber = game.getNumberOfPlayers();
					this.game = game;
					// set endpoint
					output = session.getRemote();
					this.session = session;
					setOpponents(new ArrayList<HumanPlayer>());
					
					// set player so that they can roll when it is their turn
					stored = true;
					// met threshhold
					tFlag = false;
					// send start up message
					sendMessage("Status Waiting", "WELCOME " + name);
					sendMessage("Status Waiting", "YOU ARE PLAYER #" + playerNumber);
					sendMessage("Status Waiting", "MESSAGE Waiting for opponent to connect");
						
	}


		
		

		

		

		/**
		 * get player number
		 * 
		 * @return playerNumber
		 */
		public int getPlayerNumber() {
			return playerNumber;
		}

		
		/**
		 * Start game for player
		 */
		public void start() {
			// send start message
			sendMessage("Status Waiting", "MESSAGE All players connected");

			// player is first player to join, they roll first
			if (getPlayerNumber() == 0)
				sendMessage("Status Rolling", "It is your turn to roll");
		}

		



		private boolean checkAlive() {
			if (session.isOpen())
				return true;
			else
				return false;

		}

		/**
		 * Send string to client 
		 * 
		 * @param message
		 */
		public void sendMessage(String command, String message) {
			sendJSON(command, this.name, message, new Dice(this.getDice()), this.getTotalScore(), this.getScore());

		}

		public void sendJSON(String command, String name, String message, Dice dice, int score, int storedScore) {
			ServerCommand cmd = new ServerCommand(command, name, message, dice, score, storedScore);
			ObjectMapper mapper = new ObjectMapper();

			try {
				output.sendString(mapper.writeValueAsString(cmd));
			} catch (JsonGenerationException e) {
				
				e.printStackTrace();
			} catch (JsonMappingException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		@Override
		public void roll(){
			
			
			stored = false;
			// fill array with numbers
			

			for (int i = storedDice.size(); i < 6; i++) {
				int roll = ThreadLocalRandom.current().nextInt(1, 7);
				dice.add(roll);

				// sendMessage(Integer.toString(roll));
			}
			while (dice.size() < 6) {
				dice.add(0);
			}

			sendJSON("ROLL", this.name, "Success", new Dice(dice), this.totalScore, this.score);
			// check for farkle
			
			if (game.checkFarkle(dice) == true) {
				if(farkleCounter == 2){
					farkleCounter = 0;
					totalScore -= game.getFarkleDeduction();
				}else{
					farkleCounter += 1;
				}
				sendMessage("Farkle", "Wait you Turn");
				game.endTurn(this);
			
		} else {
			for (int i = 0; i < game.getNumberOfPlayers(); i++) {

				game.getPlayer(i).sendJSON("ROLL", this.name, "Success", new Dice(dice), this.totalScore, this.score);
			}

			// if command is STORE
		}
	}
public void score(ServerCommand cmd){
	totalScore += game.checkScore(dice);
	totalScore += score;
	if(totalScore >= game.getThreshHold() && tFlag == false){
		
	tFlag = true;
	}
	else if (tFlag == false){
	totalScore = 0;	
	}
	
	score = 0;
	farkleCounter = 0;
	for (int i = 0; i < game.getNumberOfPlayers(); i++)
		game.getPlayer(i).sendJSON("SCORE", this.name, "Success", new Dice(dice), this.totalScore, this.score);
	game.endTurn(this);
}
public void store(ServerCommand cmd){
	List<Integer> tempDice = new ArrayList<Integer>();
	tempDice.addAll(dice);
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
						return;
					}

				}
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(storedDice);
				// check if store hand has non scoring die
				if (game.checkScore(temp) == 0) {
					sendMessage("Error", "You can't store non-scoring die");
					for (int x = 0; x < numOfDice; x++) {
						// remove dice
						storedDice.remove(storedDice.size() - 1);
					}
					// break to STORE label
					dice = tempDice;
					return;
				}
				// remove all dice
				dice.removeAll(dice);
				for (int i = 0; i < game.getNumberOfPlayers(); i++) {
					if (!game.getPlayer(i).getName().equals(name))
						game.getPlayer(i).sendJSON("STORE", this.name, "Success", cmd.getDice(), this.totalScore,
								this.score);
				}
				// calculate score
				score += game.checkScore(storedDice);
				// send stored dice to players

				// tell all players what score they could get
				for (int i = 0; i < game.getNumberOfPlayers(); i++) {
					game.getPlayer(i).sendJSON("STORE", this.name, "Success", new Dice(dice), this.totalScore,
							this.score);
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



		public List<HumanPlayer> getOpponents() {
			return opponents;
		}







		public void setOpponents(List<HumanPlayer> opponents) {
			this.opponents = opponents;
		}
	}


