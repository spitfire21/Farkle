/** a basic connection and insertion program to ensure mongodb is properly set up **/

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



public class MongoDBJDBC {

	public static void main(String[] args) {
	
      try{   
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         MongoDatabase db = mongoClient.getDatabase("farkle");
         
         
        db.getCollection("users").insertOne(
        		new Document()
        			.append("username","user1")
        			.append("password", "pw1")
        );
        
        db.getCollection("users").insertOne(
        		new Document()
        			.append("username","user2")
        			.append("password", "pw2")
        ); 
			
         
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}