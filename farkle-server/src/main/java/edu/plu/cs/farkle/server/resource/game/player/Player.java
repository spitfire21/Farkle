package edu.plu.cs.farkle.server.resource.game.player;

import java.util.ArrayList;
import java.util.List;

import edu.plu.cs.farkle.server.resource.game.Game;

abstract public class Player {
	protected String name;
	protected int totalScore;
	protected int score;
	protected List<Integer> dice;
	protected List<Integer> storedDice;
	protected boolean stored;
	protected Game game;
	public Player(String name, Game game) {
		this.setName(name);
		totalScore = setScore(0);
		setDice(new ArrayList<Integer>());
		setStoredDice(new ArrayList<Integer>());
		this.game = game;
	}
	public abstract void roll();
	public int getScore() {
		return score;
	}
	public int setScore(int score) {
		this.score = score;
		return score;
	}
	public int getTotalScore() {
		// TODO Auto-generated method stub
		return totalScore;
	}
	public List<Integer> getDice() {
		return dice;
	}
	public void setDice(List<Integer> dice) {
		this.dice = dice;
	}
	public List<Integer> getStoredDice() {
		return storedDice;
	}
	public void setStoredDice(List<Integer> storedDice) {
		this.storedDice = storedDice;
	}
	public boolean isStored() {
		return stored;
	}
	public void setStored(boolean stored) {
		this.stored = stored;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
