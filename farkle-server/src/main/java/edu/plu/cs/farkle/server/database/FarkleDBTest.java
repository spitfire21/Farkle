package edu.plu.cs.farkle.server.database;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class FarkleDBTest {
	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    MongoDatabase db = mongoClient.getDatabase("farkle");
    FarkleDB fdb = new FarkleDB(db);			        


	@Test
	public void testGetPassword() {
		Document user = fdb.findUser("user1");
		assertEquals("pw", user.get("password").toString());
	}
	
	@Test
	public void testSetVictories(){
		fdb.addVictory("user3");
		Document user = fdb.findUser("user3");

		assertEquals("8",user.get("victories").toString());
	}
	

}
