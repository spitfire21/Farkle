package edu.plu.cs.farkle.server.database;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import edu.plu.cs.farkle.server.resource.Victories;


public class MongoConnection {
	FarkleDB mu;
	MongoDatabase db;
	MongoClient mongoClient;
	private String[] dbVictors;
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
	public String getVictors(){
		String victorsList = "";
		dbVictors = mu.getVictors();
		 for(int i=0;i<dbVictors.length;i++){
			 victorsList += dbVictors[i] + ", ";
		 }
		 
		 return victorsList;
	}
	
	public String sendJSON(String list) throws JsonGenerationException, JsonMappingException, IOException {
		Victories vic = new Victories(list);
		ObjectMapper mapper = new ObjectMapper();
		
		
			return mapper.writeValueAsString(vic);

		
	}
	
     
}
