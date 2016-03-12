package edu.plu.cs.farkle.server.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.plu.cs.farkle.server.auth.UserCredentials;
import edu.plu.cs.farkle.server.core.FarkleServerApplication;
import edu.plu.cs.farkle.server.core.MongoServerTest;
@Path("/registration")
public class UserRegistration {
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String createUser(UserCredentials credentials) {
		String username = credentials.getUsername();
	    String password = credentials.getPassword();
		MongoServerTest db = FarkleServerApplication.getDatabase();
		
		db.createUser(username, password);
		
		String json = String.format("{ \"response\" : \"User Registered\", \"Registered\" : \"%s\" }", username );
		return json;
	}

}


