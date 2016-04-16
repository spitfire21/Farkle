package edu.plu.cs.farkle.server.database;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import edu.plu.cs.farkle.server.resource.Victories;


public class MongoConnection {
	FarkleDB mu;
	MongoDatabase db;
	MongoClient mongoClient;
	private List<String> dbVictors;
	private List<String> userRank;
	public MongoConnection(){
	 mongoClient = new MongoClient( "localhost" , 27017 );
		
       db = mongoClient.getDatabase("farkle");
      
      mu = new FarkleDB(db);
      
      
}
	public boolean createUser(String uname, String pw){
		if(mu.createUser(uname, pw)==0){
		return true;
		}
		return false;
	}
	public boolean checkUser(String uname, String pw){
		if(mu.authPassword(uname, pw)== 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public Victories getUsersRank(String userName) {
		userRank = mu.getUserRank(userName);
		Victories vic = new Victories(userRank);
		
		return vic;
	}
	
	public Victories getVictors(){
		
		dbVictors = mu.getVictors();
		Victories vic = new Victories(dbVictors);
		 
		 return vic;
	}
	
	public String sendJSON(Victories vic) throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		
			return mapper.writeValueAsString(vic);

		
	}
	public void updateVictories(String player) {
		mu.addVictory(player);
		
	}
	
     
}
