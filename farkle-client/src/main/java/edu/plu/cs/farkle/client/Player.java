package edu.plu.cs.farkle.client;

import java.util.ArrayList;

public class Player {

	private ArrayList<Integer> die;
	private int storedScore;
	private String command;
	
	private int totalScore;
	
	
	/**
	 * Gets the command from the GameClient
	 * @param command
	 * @return
	 */
	public void parseCommand(String json) {		
		
		
	}
	
	/**
	 * sets the Dice to values given from GameClient
	 * @param givenDice
	 */
	public void setDie(String json){
		die = new ArrayList<Integer>();
		
		for(int i=0;i<6;i++){
			//if dice-i.toInteger != 0
				//die.add(dice-i.toInteger)
		}	
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
	public void setStoredScore(ArrayList<Integer> givenDice) {
		storedScore = getScore(givenDice);
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
	public void setTotalScore(int storedScore, ArrayList<Integer> givenDie) {
		totalScore = storedScore + getScore(givenDie);
	}
	
	
	/**
	 * calculates a score from the given dice
	 * @param givenDice
	 */
	public int getScore(ArrayList<Integer> givenDice){ 
		//TODO dice calculations
		
		return 0;
	}
		
}