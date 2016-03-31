package edu.plu.cs.farkle.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

	private ArrayList<Integer> die;
	private int storedScore;
	private int totalScore;
	private String name;
	private String status;
	private Map<String, Player> opponents;
	
	public Player(){
		
		setOpponents(new HashMap<String, Player>());
	}
	
	
	/**
	 * Gets the command from the GameClient
	 * @param command
	 * @return
	 */
	public void parseCommand(ServerCommand command) {	
		setStatus(command.getCommand());
		//setName(command.getName());
		setDie(command.getDice().getDice());
		setTotalScore(command.getScore());
		setStoredScore(command.getStoredScore());
	}
	
	/**
	 * sets the Dice to values given from GameClient
	 * @param givenDice
	 */
	public void setDie(List<Integer> die){
		this.die = (ArrayList<Integer>) die;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getDie() {
		return die;
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