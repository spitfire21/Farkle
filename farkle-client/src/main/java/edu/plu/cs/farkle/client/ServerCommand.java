package edu.plu.cs.farkle.client;

import java.io.Serializable;

public class ServerCommand implements Serializable {
	private String command;
	private Dice dice;
	private int score;
	private int storedScore;
	public ServerCommand(String command, Dice dice, int score, int storedScore){
		this.command = command;
		this.dice = dice;
		this.score = score;
		this.storedScore = storedScore;
		
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getStoredScore() {
		return storedScore;
	}
	public void setStoredScore(int storedScore) {
		this.storedScore = storedScore;
	}

}
class Dice implements Serializable{
	private int Die1;
	private int Die2;
	private int Die3;
	private int Die4;
	private int Die5;
	private int Die6;
	public int getDie1() {
		return Die1;
	}
	public void setDie1(int die1) {
		Die1 = die1;
	}
	public int getDie2() {
		return Die2;
	}
	public void setDie2(int die2) {
		Die2 = die2;
	}
	public int getDie3() {
		return Die3;
	}
	public void setDie3(int die3) {
		Die3 = die3;
	}
	public int getDie4() {
		return Die4;
	}
	public void setDie4(int die4) {
		Die4 = die4;
	}
	public int getDie5() {
		return Die5;
	}
	public void setDie5(int die5) {
		Die5 = die5;
	}
	public int getDie6() {
		return Die6;
	}
	public void setDie6(int die6) {
		Die6 = die6;
	}
}