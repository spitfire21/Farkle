package edu.plu.cs.farkle.server.resource.game.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.plu.cs.farkle.server.resource.game.Game;

public class AIPlayer {
	private int totalScore;
	private int score;
	private int aggression;
	private String name;
	private List<Integer> dice;
	private List<Integer> storedDice;
	private Random random;
	private Game game;
	
	public AIPlayer(int aggression, String name, Game game){
		dice = new ArrayList<Integer>();
		score = totalScore = 0;
		this.aggression = aggression;
		this.game = game;
		this.name = name;
	}
	private void roll(){
		
		for(int i = storedDice.size(); i < 6; i++){
			dice.add(random.nextInt(6)+1);
		}
		
		AIfarkled();
		AIPickDice();
		score = game.checkScore(storedDice);
		startTurn();
		
		
	}
	private void AIPickDice(){
		List<Integer> temp;
		temp = checkHand(dice);
		if(temp.contains(1)){
			temp.remove(1);
			dice.remove(1);
		}
		if(temp.contains(5)){
			temp.remove(5);
			dice.remove(5);
		}
		for (int i = 0; i < 6; i++){
		while(Collections.frequency(temp, i) == 3){
			for(int j = 0; j < 3; j++){
			temp.remove(i);
			dice.remove(i);
			storedDice.add(i);
			}
		}
		}
	}
	private List<Integer> checkHand(List<Integer> checkDice){
		
			List<Integer> temp = new ArrayList<Integer>();
			while (checkDice.contains(1)) {
				checkDice.remove(Integer.valueOf(1));
				temp.add(1);
				
			}
		
			
	
			while (checkDice.contains(2)) {
				checkDice.remove(Integer.valueOf(2));
				temp.add(2);
				
			}
			
			
			while (checkDice.contains(3)) {
				checkDice.remove(Integer.valueOf(3));
				temp.add(3);
			}
			
			
			while (checkDice.contains(4)) {
				checkDice.remove(Integer.valueOf(4));
				temp.add(4);
			}
			
			
			
			while (checkDice.contains(5)) {
				checkDice.remove(Integer.valueOf(5));
				temp.add(5);
			}
			
		
			while (checkDice.contains(6)) {
				checkDice.remove(Integer.valueOf(6));
				temp.add(6);
			}
		
			return temp;
			

		}
	
	public boolean startTurn(){
		if(totalScore >= game.getWinningScore()){
			return true;
		}
		int chance = aggression*dice.size() - score/100;
		if(random.nextInt(60) + 1 <= chance){
			roll();
		} else {
			endTurn();
			
		}
		return false;
	}
	private void endTurn(){
		totalScore += score;
		score = 0;
		dice.removeAll(dice);
		storedDice.removeAll(storedDice);
		
	}
	public boolean AIfarkled(){
		if (game.checkFarkle(dice) == true){
			
			score = 0;
			endTurn();
			return true;
		}
		return false;
		
	}
	
	public boolean storeD(List<Integer> dice){
		if(storedDice.addAll(dice) == true)
		return true;
		else
			return false;
	}
	public List<Integer> getDice(){
		return dice;
	}

	public List<Integer> getStoredDice(){
		return storedDice;
	}
	public String getName() {
		
		return name;
	}
}
