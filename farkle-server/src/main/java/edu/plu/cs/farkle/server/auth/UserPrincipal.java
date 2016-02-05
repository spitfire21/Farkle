package edu.plu.cs.farkle.server.auth;

import java.security.Principal;

/**
 * Simple user object.  An instance represents an authenticated user.
 * 
 * TODO: Provide ways to store/load these from persistent storage
 */
public class UserPrincipal implements Principal {
	
	/**
	 * The user login name.
	 */
	private String userName;

	/**
	 * Initializes a UserPrincipal with the given name.
	 * @param uName the login name
	 */
	public UserPrincipal( String uName )
	{
		userName = uName;
	}
	
	/**
	 * @return The user's login name
	 */
	public String getName() {
		return userName;
	}
}
