package edu.plu.cs.farkle.server.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

/**
 * This is a simple example, not intended for use in the final product.
 * 
 * Responds with a JSON "pong" when requested via GET
 */
@Path("/ping")
public class PingPongResource {
	
	/**
	 * Returns a JSON object with two fields, "response" and "authenticated".
	 * 
	 * The "response" field is the string "pong".
	 * The "authenticated" filed is "yes" or "no" indicating whether or not this request
	 * was authenticated by the AuthenticatorFilter.
	 * 
	 * @param ctx the security context
	 * @return the JSON object
	 */
	@GET
	@Produces("application/json")
	public String getPing( @Context SecurityContext ctx ) {
		
		// If the principal is null, then authentication failed.
		String authString = "yes";
		if( ctx.getUserPrincipal() == null ) {
			authString = "no";
		}
		
		String json = String.format("{ \"response\" : \"pong\", \"authenticated\" : \"%s\" }", authString );
		return json;
	}

}
