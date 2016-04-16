//interacts with server to get and send list of victors from db to client (and other main page functions)

package edu.plu.cs.farkle.server.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import edu.plu.cs.farkle.server.core.FarkleServerApplication;
import edu.plu.cs.farkle.server.database.MongoConnection;
@Path("/victories")

public class MainPage {
	private MongoConnection db;

	
	
	public MainPage(){
		
		db = FarkleServerApplication.getDatabase();

		 
	
		
		}
	@GET 
	@Produces("application/json")
	public Response getVictories() throws JsonGenerationException, JsonMappingException, IOException{
		Victories vList = db.getVictors();
		//String vList =
			//    "{ \"user1\" : \"0\", \"mickey\" : \"0\", }";
		 		
		return Response.ok(db.sendJSON(vList)).build();
	}
	
	@Path("/user")
	@GET
	@Produces("application/json")
	public Response getUserRank(@QueryParam("uName") String uName) throws JsonGenerationException, JsonMappingException, IOException{
		
		Victories uRank = db.getUsersRank( uName );
		
		return Response.ok(db.sendJSON(uRank)).build();
	}

	}
	
	
	
	

	


