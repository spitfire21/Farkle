package edu.plu.cs.farkle.server.resource.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dice implements Serializable{
	private List<Integer> dice;
	public Dice(List<Integer> dice){
		this.dice = dice;
	}
	public Dice (){
		dice = new ArrayList<Integer>();
	}
	public List<Integer> getDice(){
		
		return dice;
	}
	public List<Integer> setDice(){
		
		return dice;
	}
}