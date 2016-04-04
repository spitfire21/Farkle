package edu.plu.cs.farkle.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Victories implements Serializable{
	
	private List<String> victors;
	
	public Victories(){
		//DUMMY
	}
	
	public Victories(List<String> v){
		victors = v;
	}
	
	public List<String> getVictors() {
		return victors;
	}
	public void setVictors(List<String> vics) {
		victors = vics;
	}
	
}
