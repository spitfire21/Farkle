package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.List;
import java.util.Map;

public class CheckFourPlusStrategy extends DefaultScoreStrategy{
	String mode;
	public CheckFourPlusStrategy(int amount, String mode) {
		super(amount);
		this.mode = mode;
	}
	public int checkScore(Map<Integer, Integer> dice){
		
		int temp1, temp2; 
		temp1 = check4(dice);
		temp2 = check5(dice);
		if(temp2 > temp1){
			temp1 = temp2; 
		}
		temp2 = check6(dice);
		if(temp2 > temp1){
			
			temp1 = temp2;
		}
		
		return temp1;
	}
	public int check4(Map<Integer, Integer> dice){
		int score = 0;
		
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==4){
					if (mode.equals("double"))
						score += 2000;
					else if (mode.equals("add")){
						score += 2000;
					}
					else if (mode.equals("set")){
						score += 2000;
					}
				}
			}
			else if (dice.get(i)==4){
				if (mode.equals("double"))
					score += i * 200;
				else if (mode.equals("add")){
					score += i * 200;
				}
				else if (mode.equals("set")){
					score += 2000;
				}
				
			}
		}
		return score;
		
	}
	
	public int check5(Map<Integer,Integer> dice){
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==5){
					if (mode.equals("double"))
						score += 4000;
					else if (mode.equals("add")){
						score += 3000;
					}
					else if (mode.equals("set")){
						score += 4000;
					}
				}
			}
			else if (dice.get(i)==5){
				if (mode.equals("double"))
					score += i * 400;
				else if (mode.equals("add")){
					score += i * 300;
				}
				else if (mode.equals("set")){
					score += 4000;
				}
			}
		}
		return score;
		
	}
	public int check6(Map<Integer, Integer> dice){
		int score = 0;
		for(int i =1; i <= 6; i++){
			if(i == 1){
				if(dice.get(i)==6){
					if (mode.equals("double"))
						score += 8000;
					else if (mode.equals("add")){
						score += 4000;
					}
					else if (mode.equals("set")){
						score += 6000;
					}
				}
			}
			else if (dice.get(i)==6){
				if (mode.equals("double"))
					score += i * 800;
				else if (mode.equals("add")){
					score += i * 400;
				}
				else if (mode.equals("set")){
					score += 6000;
				}
			}
		}
		return score;
		
	}


}
