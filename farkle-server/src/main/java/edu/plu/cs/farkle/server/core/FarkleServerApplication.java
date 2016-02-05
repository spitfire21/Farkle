package edu.plu.cs.farkle.server.core;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import edu.plu.cs.farkle.server.auth.AuthenticatorFilter;
import edu.plu.cs.farkle.server.resource.PingPongResource;

/**
 * This is the central "control" for the Farkle application.  It manages
 * the resources and filters that are enabled in the application.
 */
@ApplicationPath("/farkle")
public class FarkleServerApplication extends Application {
	
	/**
	 * This is the set of resources and filters that this application
	 * uses.  When we need to create a new resource, a single instance
	 * should be added to this set to enable it.
	 */
	private Set<Object> singletons = new HashSet<Object>();
	
	/**
	 * Instantiates the resources and adds them to the singletons Set.
	 */
	public FarkleServerApplication() {
		singletons.add( new PingPongResource() );  // Example resource, to be removed later
		singletons.add( new AuthenticatorFilter() );  // Authentication filter
	}
	
	/**
	 * @return The set of resource/filter objects for this application.
	 */
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
