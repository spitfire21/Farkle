package edu.plu.cs.farkle.server.resource;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import edu.plu.cs.farkle.server.auth.UserCredentials;
import edu.plu.cs.farkle.server.core.FarkleServerApplication;
import edu.plu.cs.farkle.server.database.MongoConnection;


@Path("/login")

public class UserService {
	

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(UserCredentials credentials) {
    	
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        

	        try {

	            // Authenticate the user using the credentials provided
	            authenticate(username, password);

	            // Issue a token for the user
	            String token = issueToken(username);

	            // Return the token on the response
	            return Response.ok(token).build();

	        } catch (Exception e) {
	            return Response.status(Response.Status.UNAUTHORIZED).build();
	        }      
	    }

	    private void authenticate(String username, String password) throws Exception {
	    	MongoConnection db = FarkleServerApplication.getDatabase();
	    	
	    	if(!db.checkUser(username, password)){
	    		System.out.println("FAILED LOGIN");
	    		throw new Exception();
	    	}
	    }

	    private String issueToken(String username) {
	    	
	       Key key = FarkleServerApplication.getKey();
	       String token = Jwts.builder().setSubject(username).signWith(SignatureAlgorithm.HS512, key).compact();
	    	return token;
	    }
	}
