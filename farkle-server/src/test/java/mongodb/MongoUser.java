package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static java.util.Arrays.asList;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;


/**
A mongo class for user data entry and queries
**/

public class MongoUser {
	
	private MongoDatabase db;
	
	public MongoUser(MongoDatabase database) {
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
	 * return document if user exists, NULL if not
	 * DO we want to assume there will only be one user?
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
	
	public ArrayList<Document> getVictors() {
		FindIterable<Document> iter = db.getCollection("users").find()
		        .sort(new Document("victories", -1).append("victories", -1));
		
		ArrayList<Document> victors = new ArrayList<Document>();
		
		iter.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		      victors.add(document);
		    }
		});
		
		
		
		return victors;
		
		/*AggregateIterable<Document> iter = db.getCollection("users").aggregate(asList(
		        new Document("$group", new Document("victories", "$victories"))));

		ArrayList<Document> victors = new ArrayList<Document>();

		
		iter.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		      victors.add(document);
		    }
		});*/
	}
	
	
	public String getPw(String userName) {
		
		ArrayList users = findUser(userName);
		
		
		
		return null;
		
		
	}
	
	/**
	 * 
	 * @param db
	 * @param un
	 * @param pw
	 * @return 0 if user is authenticated, -1 if not
	 */
	public int authPassword(String un, String pw) {
		
		return 0;
	}
	
	
	/**
	 * sets user Settings
	 * @param SettingInput array with user input for each setting
	 * TODO array vs hashmap
	 */
	public void setSettings(int[] SettingInput) {
		
	}
	
	/**
	 * gets the user's default settings
	 * @param username
	 * return an array (hashmap?) holding the users settings
	 */
	public int[] getSettings(String username) {
		int[] settingArray = new int[10];
		
		return settingArray;
	}
}
