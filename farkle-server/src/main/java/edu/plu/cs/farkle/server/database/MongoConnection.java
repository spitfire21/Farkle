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
	private ArrayList<String> dbVictors;
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
		 
		 for(int i=0;i<dbVictors.size();i++){
			 victorsList += dbVictors.get(i) + "/n";
		 }
		 
		 return victorsList;
	}
	
	public String sendJSON(String list) {
		Victories vic = new Victories(list);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			return mapper.writeValueAsString(vic);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
     
}
