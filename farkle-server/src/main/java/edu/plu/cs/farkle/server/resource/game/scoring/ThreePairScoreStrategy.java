package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.List;
import java.util.Map;

public class ThreePairScoreStrategy extends DefaultScoreStrategy{

	public ThreePairScoreStrategy(int amount) {
		super(amount);
		
	}
	@Override
	public int checkScore(Map<Integer, Integer> dice){
		
		int count = 0;
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(dice.get(i)==2){
				count++;
			}
		}
		if(count == 3){
			score = amount;
		}
		return score;
		
	}
			
	

}
