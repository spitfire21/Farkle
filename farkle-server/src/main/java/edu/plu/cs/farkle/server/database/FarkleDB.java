package edu.plu.cs.farkle.server.database;

import static java.util.Arrays.asList;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
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
	
	public FarkleDB(){
		
	}
	
	public void setDB(MongoDatabase database){
		db = database;
	}
	
	
	/**
	 * adds a new user to the database (collection user)
	 * @param un
	 * @param pw
	 * returns -1 if username is in use, 0 if successful
	 */
	public int createUser(String un, String pw) {
		if(findUser(un) != null)
			return -1;
		
		db.getCollection("users").insertOne(
        		new Document()
        			.append("_id",un)
        			.append("password",pw)
        			.append("victories", 0)
        );
		return 0;
	}
	
	/**
	 * queries database to find user
	 * @param db
	 * @param un
	 * returns document of user found (might switch to json)
	 */
	public Document findUser(String userName) {
		AggregateIterable<Document> iter = db.getCollection("users").aggregate(asList(
				new Document("$match", new Document("_id",userName))));
		
		//TODO get rid of this arraylist
		final ArrayList<Document> users = new ArrayList<Document>();
		
		iter.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		      users.add(document);
		    }
		});
		if(users.isEmpty()){
			return null;
		}else{
		return users.get(0);
		}
	}	
	
	/**
	 * 
	 * @return a json containing top victors and their win count
	 */
	public ArrayList<Document> getVictors() {
		FindIterable<Document> iter = db.getCollection("users").find()
		        .sort(new Document("victories", -1).append("victories", -1));
		
		final ArrayList<Document> victors = new ArrayList<Document>();
		
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
	 */
	public void addVictory(String userName) {
		
		
		int victories = Integer.parseInt(findUser(userName).get("victories").toString());
		db.getCollection("users").updateOne(new Document("_id", userName),
		        new Document("$set", new Document("victories", victories+1)));
	}
	/**
	 * 
	 * @param db
	 * @param un
	 * @param pw
	 * @return 0 if user is authenticated, -1 if not
	 */
	public int authPassword(String un, String pw) {
		
		
		MongoCollection<Document> coll = db.getCollection("users");
		
		BasicDBObject searchQuery = new BasicDBObject();
		
		searchQuery.put("_id", un);	
		searchQuery.put("password", pw);
		
		if(coll.find(searchQuery).iterator().hasNext())
			return 0;
		else
			return -1;
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
