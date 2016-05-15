package edu.plu.cs.farkle.server.resource.game.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import edu.plu.cs.farkle.server.resource.game.Dice;
import edu.plu.cs.farkle.server.resource.game.Game;
import edu.plu.cs.farkle.server.resource.game.player.Player;

public class AIPlayer extends Player{
	
	private int aggression;


	private Random random;

	
	public AIPlayer(int aggression, String name, Game game){
		super(name,game);
		random = new Random();
		
		
		this.aggression = aggression;
		
		
	}
	@Override
	public void roll(){
		System.out.println(storedDice.size());
		for(int i = storedDice.size(); i < 6; i++){
			dice.add(random.nextInt(6)+1);
		}
		System.out.println(dice);
		
		if(isFarkle() == false){
		
		pickDice();
		System.out.println(storedDice);
		score = game.checkScore(storedDice);
	
		if(storedDice.size() == 6){
			storedDice.removeAll(storedDice);
		}
		try {
			//Thread.sleep(1500);
			TimeUnit.MILLISECONDS.sleep(1500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		startTurn();
		}
		
		
	}
	private void pickDice(){
		List<Integer> temp;
		temp = checkHand(dice);
		
		for (int i = 0; i < 6; i++){
		while(Collections.frequency(temp, i) == 3){
			for(int j = 0; j < 3; j++){
			temp.remove((Integer)i);
			//dice.remove(i);
			storedDice.add(i);
			}
		}
		}
		if(random.nextInt(10)+1 < aggression  && aggression > 6 && temp.contains(1)){
			temp.remove((Integer)1);
			storedDice.add(1);
		}else{
		while(temp.contains(1)){
			temp.remove((Integer)1);
			
		
				storedDice.add(1);
			
			
			//dice.remove(1);
			}
		}
		if(random.nextInt(10)+1 < aggression  && aggression > 6 && temp.contains(5)){
			temp.remove((Integer)5);
			storedDice.add(5);
		}else {
		while(temp.contains(5)){
			temp.remove((Integer)5);
			
				storedDice.add(5);
			
			//dice.remove(5);
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
		int chance = aggression*(6-dice.size()) - score/50;
		if(dice.size()==0 && storedDice.size() == 0){
			roll();
		}
		else if(random.nextInt(60) + 1 <= chance){
			roll();
		} else {
			endTurn();
			
		}
		return false;
	}
	private void endTurn(){
		totalScore += score;
		System.out.println(name + " score is: " + totalScore);
		for(int i = 0; i < game.getNumberOfPlayers();i++){
			game.getPlayer(i).sendJSON("SCORE", name, "Success", new Dice(dice), this.totalScore, this.score);
		}
		score = 0;
		dice.removeAll(dice);
		storedDice.removeAll(storedDice);
		
	}
	public boolean isFarkle(){
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
	public int getTotalScore() {
		// TODO Auto-generated method stub
		return totalScore;
	}
	public int getScore() {
		// TODO Auto-generated method stub
		return score;
	}
}
