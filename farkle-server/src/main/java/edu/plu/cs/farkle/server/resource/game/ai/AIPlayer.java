package edu.plu.cs.farkle.server.resource.game.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer {
	private int totalScore;
	private int score;
	private int aggression;
	private List<Integer> dice;
	private Random random;
	
	public AIPlayer(int aggression){
		dice = new ArrayList<Integer>();
		score = totalScore = 0;
		this.aggression = aggression;
	}
	private void roll(){
		for(int i = dice.size(); i < 6; i++){
			dice.add(random.nextInt(6)+1);
		}
		
		
	}
	public void startTurn(){
		int chance = aggression*dice.size() - score/100;
		if(random.nextInt(60) + 1 <= chance){
			roll();
		} else {
			endTurn();
		}
		
	}
	private void endTurn(){
		totalScore += score;
		score = 0;
		dice.removeAll(dice);
		
	}
	

}
