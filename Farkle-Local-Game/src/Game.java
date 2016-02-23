import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	 Player currentPlayer;
	 int numOfOnlinePlayers;
	 public boolean checkFarkle(List<Integer> dice){
		 if(dice.contains(1)){
			 return false;
		 } else if (Collections.frequency(dice, 1) == 3){
			 return false;
		 } else if (Collections.frequency(dice, 2) == 3){
			 return false;
		 } else if (Collections.frequency(dice, 3) == 3){
			 return false;
		 } else if (Collections.frequency(dice, 4) == 3){
			 return false;
		 } else if (Collections.frequency(dice, 5) == 3){
			 return false;
		 }else if (Collections.frequency(dice, 6) == 3){
			 return false;
		 } 
		 else if (dice.contains(5)){
			 return false;
		 }
		return true;
		 
	 }
	 public boolean canRoll(Player player){
		 if (player.stored && currentPlayer==player)
			 return true;
		
		 return false;
		 
	 }
	 public void endTurn(Player player){
		 player.storedScore=0;
		player.dice.removeAll(player.dice);
		player.storedDice.removeAll(player.storedDice);
		player.output.println("WAIT YOUR TURN");
		player.stored = true;
		if (numOfOnlinePlayers-1 == player.getPlayerNumber()){
			currentPlayer = player.opponents.get(0);
		}
		else {
		 currentPlayer = player.opponents.get(player.getPlayerNumber());
		}
		currentPlayer.output.println("It is now your turn, please roll");
		
	 }
	 /**
	  * Really ugly needs to be redone
	  * @param storedDice
	  * @return
	  */
	 public int checkScore(List<Integer> storedDice){
		 int score = 0;
		 int count = 0;
		 while(storedDice.contains(1)){
				storedDice.remove(Integer.valueOf(1));
				count++;
			}
		 if(count == 3){
			 score += 1000;
			
		 }
		
		 else {
			 score += count * 100;
			 
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 while(storedDice.contains(2)){
				storedDice.remove(Integer.valueOf(2));
				count++;
			}
		 if(count == 3){
			 score += 200;
			 
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 while(storedDice.contains(3)){
				storedDice.remove(Integer.valueOf(3));
				count++;
			}
		 if(count == 3){
			 score += 300;
			
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 while(storedDice.contains(4)){
				storedDice.remove(Integer.valueOf(4));
				count++;
			}
		 if(count == 3){
			 score += 400;
		
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 while(storedDice.contains(5)){
				storedDice.remove(Integer.valueOf(5));
				count++;
			}
		 if(count == 3){
			 score += 500;
			 
		 }
		 else {
			 score += count * 50;
			 
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 while(storedDice.contains(6)){
				storedDice.remove(Integer.valueOf(6));
				count++;
			}
		 if(count == 3){
			 score += 600;
			 
		 }
		 for (int i = 0; i < count; i++){
			 storedDice.add(0);
		 }
		 count = 0;
		 return score;
		 
	 }
	 /**
	  * I should really start commenting
	  * @author Cody-Desktop
	  *
	  */
	class Player extends Thread{
		List<Player> opponents;
		int playerNumber, score, storedScore;
		boolean stored;
		Socket socket;
		BufferedReader input;
        PrintWriter output;
        List<Integer> dice;
        List<Integer> storedDice;
		public Player(Socket socket, int number) {
			numOfOnlinePlayers++;
			this.socket = socket;
			opponents = new ArrayList<Player>();
			dice = new ArrayList<Integer>();
			storedDice = new ArrayList<Integer>();
			playerNumber = number;
			stored = true;
			try {
                input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME PLAYER NUMBER " + number);
                output.println("MESSAGE Waiting for opponent to connect");
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
			}
		public void addOpponent(Player opponent){
			opponents.add(opponent);
			}
		public int getPlayerNumber(){
			return playerNumber;
			}
		 public void run() {
			 output.println("MESSAGE All players connected");
			 if(getPlayerNumber()==0)
				 output.println("It is your turn to roll");
			 try {
	         while(true){
	        	 
					String command = input.readLine();
					System.out.println(command);
					if (command.startsWith("ROLL") && canRoll(this)) {
						stored = false;
					
						
						for(int i=storedDice.size(); i < 6; i++){
							int roll = ThreadLocalRandom.current().nextInt(1, 7);
							dice.add(roll);
							output.println(roll);
						}
						if(checkFarkle(dice)){
							output.println("FARKLE :(");
							endTurn(this);
						}
					}
					STORE:
					if (command.startsWith("STORE ")) {
						if(dice.size()>0){
							String[] splits = command.split("[ ]");
							if (splits.length == 7){
								output.println("Can't store all of your dice instead score");
							} else if (splits.length == 1){
								output.println("You must store something");
							} else {
								for (int i = 1; i < splits.length; i++){
									if(dice.contains(Integer.valueOf(splits[i]))){
									storedDice.add(Integer.valueOf(splits[i]));
									}
									else {
										output.println("INVALID STORE WRITE NUMBERS AGAIN");
										storedDice.removeAll(storedDice);
										break STORE;
									}
									
								}
								if(checkFarkle(storedDice)){
									output.println("You can't store non-scoring dice");
									storedDice.removeAll(storedDice);
									break STORE;
								}
								dice.removeAll(dice);
								storedScore += checkScore(storedDice);
								output.println("Your current stored score is: " + storedScore);
								
								
								stored = true;
								if(storedDice.size() == 6){
									storedDice.removeAll(storedDice);
								}
							}
						}
					}
					if (command.startsWith("SCORE")) {
						score +=checkScore(dice);
						score += storedScore;
						output.println("YOUR CURRENT SCORE: " + score);
						endTurn(this);
					}
						
						
	         }
				} catch (IOException e) {
					 System.out.println("Player died: " + e);
					e.printStackTrace();
				} try {socket.close();} catch (IOException e) {}
	         }
				
	         }
		}
	
		
	

