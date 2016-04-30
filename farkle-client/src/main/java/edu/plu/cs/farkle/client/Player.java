package edu.plu.cs.farkle.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Player {

	private ArrayList<Integer> dice;
	private int storedScore;
	private int totalScore;
	private String name;
	private ServerCommand command;
	private String status;
	private Map<String, Player> opponents;
	
	public Player(){
		dice = new ArrayList<Integer>();
		setOpponents(new HashMap<String, Player>());
	}
	public Player(ServerCommand command){
		dice = new ArrayList<Integer>();
		setOpponents(new HashMap<String, Player>());
		parseCommand(command);
	}
	
	
	/**
	 * Gets the command from the GameClient
	 * @param command
	 * @return
	 */
	public void parseCommand(ServerCommand command) {	
		setStatus(command.getCommand());
		//setName(command.getName());
		setDice(command.getDice().getDice());
		setTotalScore(command.getScore());
		setStoredScore(command.getStoredScore());
		this.command = command;
	}
	
	/**
	 * sets the Dice to values given from GameClient
	 * @param givenDice
	 */
	public void setDice(ArrayList<Integer> rDice){
	
		dice = rDice;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getDice() {
		return dice;
	}
	
	/**
	 * sets the stored (temp) score from the banked dice in the match
	 * @param givenDice
	 */
	public void setStoredScore(int score) {
		storedScore = score;
	}
	
	/**
	 * @return StoredScore
	 */
	public int getStoredScore() {
		return storedScore;
	}
	
	/**
	 * sets the user's final score from their round
	 * @param storedScore 
	 * @param rolledDice
	 */
	public void setTotalScore(int score) {
		totalScore += score;
	}
	
	


	public int getTotalScore() {
		return totalScore;
	}

	

	public String getName() {
		return name;
	}
	
	
	
	
	public String getOppenentScore(){
		String name = null;
		int score;
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, Player>> iterator = opponents.entrySet().iterator();
		
		while(iterator.hasNext()){
            Map.Entry<String, Player> entry = (Entry<String, Player>) iterator.next();
            name = entry.getKey();
            score = entry.getValue().getStoredScore();
            sb.append(name);
            sb.append(" ");
            sb.append(score);
        }
		return sb.toString();
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void addOpponent(String name, Player player){
		opponents.put(name, player);
	}

	public Map<String, Player> getOpponents() {
		return opponents;
	}


	public void setOpponents(Map<String, Player> opponents) {
		this.opponents = opponents;
	}
		
}