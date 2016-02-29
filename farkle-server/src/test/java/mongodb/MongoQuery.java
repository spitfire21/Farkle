/** a basic query to ensure mongodb has been properly installed **/
package mongodb;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import org.bson.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;


public class MongoQuery {

	public static void main(String[] args) {
		
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
        MongoDatabase db = mongoClient.getDatabase("farkle");


		System.out.println(db.getCollection("users").find(
		        new Document("users.username", "user1")).toString());
		
		
		
	}
}