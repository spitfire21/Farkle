package edu.plu.cs.farkle.server.resource.game.scoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoring {
	ArrayList<DefaultScoreStrategy> scoringClasses;
	public Scoring(){
		scoringClasses = new ArrayList<DefaultScoreStrategy>();
	}
	public void addScoreSet(DefaultScoreStrategy scoreSet){
		scoringClasses.add(scoreSet);
	}
	/**
	 * Checks score by creating a hash map and checking frequency.
	 * 
	 * @param storedDice
	 * @return
	 */
	public int checkScore(List<Integer> storedDice) {
		int score = 0;
		Map<Integer, Integer> counter = getHashMap(storedDice);
		for(int i = 0; i < scoringClasses.size(); i++)
			if((score = scoringClasses.get(i).checkScore(counter)) != 0)
				return score;
		
		
		return score;

	}
	protected HashMap<Integer, Integer>getHashMap(List<Integer> storedDice){
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		if(counter.isEmpty())
			for (int i = 0; i <= 6; i++) {
				counter.put(i, 0);
			}
		for (int i = 0; i < storedDice.size(); i++) {

			int temp = counter.get(storedDice.get(i));
			temp++;
			counter.replace(storedDice.get(i), temp);
			storedDice.set(i, 0);
			System.out.println("num of dice: " + temp);

		}
		return (HashMap<Integer, Integer>) counter;
		
	}
}
