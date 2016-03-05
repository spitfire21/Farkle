package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static java.util.Arrays.asList;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;


/**
A mongo class for user data entry and queries
**/

public class MongoUser {

	//TODO figure out best way to parse in MongoDatabase object
	
	/**
	 * adds a new user to the database (collection user)
	 * @param un
	 * @param pw
	 * returns -1 if username is in use, 0 if successful
	 */
	public int createUser(MongoDatabase db, String un, String pw) {
		//TODO check if user exists
		
		db.getCollection("users").insertOne(
        		new Document()
        			.append("username",un)
        			.append("password",pw)
        );
		return 0;
	}
	/**
	 * queries database to find user
	 * @param db
	 * @param un
	 * return password
	 */
	public FindIterable<Document> findUser(MongoDatabase db, String userName) {
		String collection = "users";
		String field = "username";
		FindIterable<Document> doc = db.getCollection(collection).find(eq(field, userName)).limit(1);	
		
		
		return doc;
	}
	
	/**
	 * 
	 * @param db
	 * @param un
	 * @param pw
	 * @return 0 if user is authenticated, -1 if not
	 */
	public int authPassword(MongoDatabase db, String un, String pw) {
		
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
