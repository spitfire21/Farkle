package edu.plu.cs.farkle.server.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class MongoConnection {
	FarkleDB mu;
	MongoDatabase db;
	MongoClient mongoClient;
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
     
}
