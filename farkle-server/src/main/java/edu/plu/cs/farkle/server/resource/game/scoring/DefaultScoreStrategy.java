package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.List;
import java.util.Map;

public class DefaultScoreStrategy {
	int amount;
	public DefaultScoreStrategy(int amount){
		this.amount = amount;
	}
	/**
	 * Checks score by creating a hash map and checking frequency.
	 * 
	 * @param storedDice
	 * @return
	 */
	public int checkScore(Map<Integer, Integer> counter) {
		int score = 0;
		
		

		
			for(int i = 1; i <= 6; i++){
				if(i != 1 && i != 5){
					if(counter.get(i)!=3 && counter.get(i)!=0){
						return 0;
					}
				}
				
			}
			if (counter.get(1) == 3) {
				score += 1000;
			} else if (counter.get(1) >= 3) {
				score += 1000;
				score += counter.get(1) * 100 - 300;
			} else {
				score += counter.get(1) * 100;
			}
			if (counter.get(2) == 3) {
				score += 200;
			}
			if (counter.get(3) == 3) {
				score += 300;
			}
			if (counter.get(4) == 3) {
				score += 400;
			}
			if (counter.get(5) == 3) {
				score += 500;
			} else if (counter.get(5) >= 3) {
				score += 500;
				score += counter.get(5) * 50 - 150;
			} else {
				score += counter.get(5) * 50;
			}
			if (counter.get(6) == 3) {
				score += 600;
			}
		
		
		return score;

	}

}
