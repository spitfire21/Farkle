package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.List;
import java.util.Map;

public class FullHouseScoreStrategy extends DefaultScoreStrategy {

	public FullHouseScoreStrategy(int amount) {
		super(amount);
	}
	@Override
	public int checkScore(Map<Integer, Integer> dice){
		
		boolean flag = false;
		boolean flag2 = false;
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(dice.get(i)==3 && flag2 == false){
				flag = true;
				if(i == 1){
					score += 1000;
				}
				else{
					score += i*100;
				}
			}
			else if(dice.get(i)==2 && flag == true){
				score += amount;
				return score;
			}
			else if(dice.get(i)==2 && flag == false){
				score+=amount;
				flag2 = true;
			}
			else if(dice.get(i)==3 && flag2 == true ){
				if(i == 1){
					score += 1000;
				}
				else{
					score += i*100;
				}
				return score;
			}
			
		}
		return 0;
	}

}
