//interacts with server to get and send list of victors from db to client (and other main page functions)

package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import edu.plu.cs.farkle.server.database.FarkleDB;

import static java.util.concurrent.TimeUnit.*;
public class MainPage {

	private MongoClient mongoClient;
	private MongoDatabase db;
	private ArrayList<String> dbVictors;
	private FarkleDB fd;
	
	private Session session;
	private RemoteEndpoint output;

	
	
	public MainPage(Session session){
		
		output = session.getRemote();
		this.session = session;
		
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 db = mongoClient.getDatabase("farkle");
		 
		 fd = new FarkleDB(db);

		 dbVictors = fd.getVictors();
		 
		 String vList = getVictors();
		 
		 sendJSON(vList);

	}
	
	private String getVictors(){
		String victorsList = "";
		 
		 for(int i=0;i<dbVictors.size();i++){
			 victorsList += dbVictors.get(i) + "/n";
		 }
		 
		 return victorsList;
	}
	
	private void sendJSON(String list){
		Victories vic = new Victories(list);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			output.sendString(mapper.writeValueAsString(vic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

	
}

