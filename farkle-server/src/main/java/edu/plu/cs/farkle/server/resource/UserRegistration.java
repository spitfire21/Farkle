package edu.plu.cs.farkle.server.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/login")
public class UserRegistration {
	public static List<String> Users = new ArrayList<String>();
	
	@POST
	@Produces("application/json")
	public String createUser(@FormParam("name") String email) {
		
		Users.add(email);
		/*
		 * TODO add code to create a user in the database
		 */
		String json = String.format("{ \"response\" : \"User Registered\", \"Registered\" : \"%s\" }", email );
		return json;
	}

}


