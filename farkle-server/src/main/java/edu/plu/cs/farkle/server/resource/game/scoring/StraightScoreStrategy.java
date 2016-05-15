package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.List;
import java.util.Map;

public class StraightScoreStrategy extends DefaultScoreStrategy {

	public StraightScoreStrategy(int amount) {
		super(amount);
	}
	@Override
	public int checkScore(Map<Integer, Integer> dice){
		
			int score = amount;
			for(int i =1; i <= 6; i++){
				if(dice.get(i)==0){
					score = 0;
				}
			}
			return score;
		
	}

}
