package edu.plu.cs.farkle.server.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;
import java.security.Key;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import edu.plu.cs.farkle.server.core.FarkleServerApplication;


@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class AuthenticatorFilter implements ContainerRequestFilter {

	/**
	 * This method is called prior to every request.  It reads the HTTP 
	 * Authorization header and attempts to authenticate the client.  If successful,
	 * it inserts a SecurityContext object into the request.  Otherwise, it does
	 * nothing.
	 */
	public void filter(ContainerRequestContext request) throws IOException {
		
		
		// Get the authorization header (if it exists)
		String authorization = request.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		// If there is no authorization header, do nothing
		if( authorization == null || !authorization.startsWith("Bearer ")) 
			return;
		
		// Whether or not this request is over HTTPS
		boolean secure = request.getSecurityContext().isSecure();
		
		// Extract the token from the HTTP Authorization header
        String token = authorization.substring("Bearer".length()).trim();
		try {

            // Validate the token
            validateToken(token);

        } catch (Exception e) {
            request.abortWith(
               Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
	private void validateToken(String token) throws Exception {
		 Key key = FarkleServerApplication.getKey();
		try {
			// TODO check if token is stored in database
		    Jwts.parser().setSigningKey(key).parseClaimsJws(token);

		    //OK, we can trust this JWT
		    

		} catch (SignatureException e) {

		    //don't trust the JWT!
		}
    }	
    	
		// If we get this far, we have an authorization header, so validate the 
		// authorization.
		//
		// Currently, this just checks to see if the header is the word "secret".  
		// TODO: Update this to handle a username/password on initial authorization, and
		//     session keys for session management.
//		if( UserRegistration.Users.contains(authorization))
//		{
//			// TODO: Create a "real" UserPrincipal
//			UserPrincipal user = new UserPrincipal(authorization);
//			/*
//			 * Create session management with keys
//			 */
//			request.setSecurityContext(new FarkleSecurityContext(user, secure));
//		}
		
	
	}


