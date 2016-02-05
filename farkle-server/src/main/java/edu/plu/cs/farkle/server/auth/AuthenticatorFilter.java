package edu.plu.cs.farkle.server.auth;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
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
		if( authorization == null ) 
			return;
		
		// Whether or not this request is over HTTPS
		boolean secure = request.getSecurityContext().isSecure();
				
		// If we get this far, we have an authorization header, so validate the 
		// authorization.
		//
		// Currently, this just checks to see if the header is the word "secret".  
		// TODO: Update this to handle a username/password on initial authorization, and
		//     session keys for session management.
		if( authorization.equals("secret") )
		{
			// TODO: Create a "real" UserPrincipal
			UserPrincipal user = new UserPrincipal("dummy-user");
			request.setSecurityContext(new FarkleSecurityContext(user, secure));
		}		
	}
}
