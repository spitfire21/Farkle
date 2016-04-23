package edu.plu.cs.farkle.server.resource.game;

import java.util.Map;

public class Variation {

	public int CheckStraight(Map<Integer, Integer> dice){
		int score = 1000;
		for(int i =1; i <= 6; i++){
			if(dice.get(i)==0){
				score = 0;
			}
		}
		return score;
	}
	public int ThreePair(Map<Integer, Integer> dice){
		int count = 0;
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(dice.get(i)==2){
				count++;
			}
		}
		if(count == 3){
			score = 1500;
		}
		return score;
	}
	public int FullHouse(Map<Integer, Integer> dice){
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
				score += 250;
				return score;
			}
			else if(dice.get(i)==2 && flag == false){
				score+=250;
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
	public int Check4(Map<Integer, Integer> dice){
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==4){
					score += 2000;
				}
			}
			else if (dice.get(i)==4){
				score += i * 200;
			}
		}
		return score;
		
	}
	public int Check5(Map<Integer, Integer> dice){
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==5){
					score += 4000;
				}
			}
			else if (dice.get(i)==5){
				score += i * 400;
			}
		}
		return score;
		
	}
	public int Check6(Map<Integer, Integer> dice){
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==6){
					score += 8000;
				}
			}
			else if (dice.get(i)==6){
				score += i * 800;
			}
		}
		return score;
		
	}

}
