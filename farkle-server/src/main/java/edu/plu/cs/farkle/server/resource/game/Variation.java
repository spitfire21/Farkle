package edu.plu.cs.farkle.server.resource.game;

import java.util.Map;

public class Variation {
	int straight;
	int threePair;
	int fullHouse;
	String mode;
	public Variation(int straight, int threePair, int fullHouse, String mode ){
		this.straight = straight;
		this.threePair = threePair;
		this.fullHouse = fullHouse;
		this.mode = mode;
	}

	public int CheckStraight(Map<Integer, Integer> dice){
		int score = straight;
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
			score = threePair;
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
				score += fullHouse;
				return score;
			}
			else if(dice.get(i)==2 && flag == false){
				score+=fullHouse;
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
	public int checkAll(Map<Integer, Integer> dice){
		int temp1, temp2; 
		temp1 = Check4(dice);
		temp2 = Check5(dice);
		if(temp2 > temp1){
			temp1 = temp2; 
		}
		temp2 = Check6(dice);
		if(temp2 > temp1){
			
			temp1 = temp2;
		}
		
		return temp1;
	}
	public int Check4(Map<Integer, Integer> dice){
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
	
	public int Check5(Map<Integer,Integer> dice){
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
	public int Check6(Map<Integer, Integer> dice){
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
