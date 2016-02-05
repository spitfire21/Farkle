package edu.plu.cs.farkle.server.auth;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

/**
 * An instance of this class represents the security context for a given
 * request.  It contains the authenticated UserPrincipal, and can provide
 * role-based authorization (not implemented yet).
 */
public class FarkleSecurityContext implements SecurityContext {
	
	/**
	 * The UserPrincipal associated with this context.
	 */
	private UserPrincipal user;
	
	/**
	 * Whether or not this context was created by authentication over a secure
	 * (HTTPS) link.
	 */
	private boolean secure;
	
	/**
	 * Initializes this security context with the given principal.
	 * @param user The UserPrincipal associated with this context
	 * @param sec Whether or not this context was created via authentication over a secure link.
	 */
	public FarkleSecurityContext( UserPrincipal user, boolean sec ) {
		this.user = user;
		this.secure = sec;
	}

	/**
	 * @return A String indicating the authentication scheme that was used.
	 */
	public String getAuthenticationScheme() {
		// Represents our own custom authentication scheme
		return "FarkleAuthentication";
	}

	/**
	 * @return the UserPrincipal associated with this context.
	 */
	public Principal getUserPrincipal() {
		return user;
	}

	/**
	 * @return whether or not this SecurityContext was created by authentication
	 * over a secure link (HTTPS).
	 */
	public boolean isSecure() {
		return secure;
	}

	/**
	 * This method is used to determine whether or not a user has the given
	 * role.  Used for role-based authorization.  Currently, it just returns
	 * true for all roles.
	 * 
	 * @param role the role
	 * @return whether or not the user has the given role
	 */
	public boolean isUserInRole(String role) {
		// TODO: Implement roles.
		return true;
	}
}
