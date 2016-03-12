package edu.plu.cs.farkle.server.database;

import static java.util.Arrays.asList;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

/**
 * This is the class including methods related to working with the database
 */

public class FarkleDB {
	
	private MongoDatabase db;
	
	/**
	 * sets the MongoDatabase to db;
	 * @param database
	 */
	public FarkleDB(MongoDatabase database) {
		db = database;
	}
	
	
	/**
	 * adds a new user to the database (collection user)
	 * @param un
	 * @param pw
	 * returns -1 if username is in use, 0 if successful
	 */
	public int createUser(String un, String pw) {
		if(findUser(un).size()!=0 )
			return -1;
		
		db.getCollection("users").insertOne(
        		new Document()
        			.append("_id",un)
        			.append("password",pw)
        );
		return 0;
	}
	
	/**
	 * queries database to find user
	 * @param db
	 * @param un
	 * returns document of user found (might switch to json)
	 */
	public ArrayList<Document> findUser(String userName) {
		AggregateIterable<Document> iter = db.getCollection("users").aggregate(asList(
				new Document("$match", new Document("_id",userName))));
		
		ArrayList<Document> users = new ArrayList<Document>();
		
		iter.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		      users.add(document);
		    }
		});
		
		return users;
		
	}	
	
	/**
	 * 
	 * @return a json containing top victors and their win count
	 */
	public ArrayList<Document> getVictors() {
		AggregateIterable<Document> iter = db.getCollection("users").aggregate(asList(
		        new Document("$group", new Document("_id", "$victories"))));

		ArrayList<Document> victors = new ArrayList<Document>();

		
		iter.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		      victors.add(document);
		    }
		});
		
		return victors;
	}
	/**
	 * updates username's document to add to their number of victories
	 * @param userName the user to add the victory to
	 * @return 0 if success
	 */
	public int addVictory(String userName) {
		return 0;
	}
	
	
	/**
	 * sets user Settings
	 * @param SettingInput array with user input for each setting
	 */
	public void setSettings(int[] SettingInput) {
		
	}
	
	/**
	 * gets the user's default settings
	 * @param username
	 * returns an array holding the users settings
	 */
	public JSON getSettings(String username) {
		
		return null;
	}
	
	
}
