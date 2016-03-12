package edu.plu.cs.farkle.server.database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class MongoServerTest {
	FarkleDB mu;
	MongoDatabase db;
	MongoClient mongoClient;
	public MongoServerTest(){
	 mongoClient = new MongoClient( "localhost" , 27017 );
		
       db = mongoClient.getDatabase("farkle");
      
      mu = new FarkleDB(db);
      
      
}
	public void createUser(String uname, String pw){
	mu.createUser(uname, pw);
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
