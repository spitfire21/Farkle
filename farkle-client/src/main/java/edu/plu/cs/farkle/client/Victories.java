package edu.plu.cs.farkle.client;

import java.io.Serializable;
import java.util.ArrayList;

import org.bson.Document;

public class Victories implements Serializable{
	
	private String victors;
	
	Victories(String v){
		victors = v;
	}
	
	public String getVictors() {
		return victors;
	}
	public void setVictors(String vics) {
		victors = vics;
	}
}
