package edu.plu.cs.farkle.client.game;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ServerCommand implements Serializable {
	

	private String command;
	private String name;
	private String message;
	private Dice dice;
	private int score;
	private int storedScore;
	public ServerCommand(String command, String name, String message, Dice dice, int score, int storedScore){
		this.command = command;
		this.setName(name);
		this.setMessage(message);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
public ServerCommand(){
	
}
}
class Dice implements Serializable{
	private ArrayList<Integer> dice;
	public Dice(ArrayList<Integer> dice){
		this.dice = dice;
	}
	public Dice (){
		dice = new ArrayList<Integer>();
	}
	public ArrayList<Integer> getDice(){
		
		return dice;
	}
	public List<Integer> setDice(){
		
		return dice;
	}
}