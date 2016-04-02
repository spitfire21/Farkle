package edu.plu.cs.farkle.server.core;

import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import edu.plu.cs.farkle.server.auth.AuthenticatorFilter;
import edu.plu.cs.farkle.server.auth.SocketFilter;
import edu.plu.cs.farkle.server.database.FarkleDB;
import edu.plu.cs.farkle.server.database.MongoConnection;
import edu.plu.cs.farkle.server.resource.GameServlet;
import edu.plu.cs.farkle.server.resource.PingPongResource;
import edu.plu.cs.farkle.server.resource.UserRegistration;
import edu.plu.cs.farkle.server.resource.UserService;

/**
 * This is the central "control" for the Farkle application.  It manages
 * the resources and filters that are enabled in the application.
 */
@ApplicationPath("/farkle")
public class FarkleServerApplication extends Application {
	static Key key;
	static MongoConnection db;
	/**
	 * This is the set of resources and filters that this application
	 * uses.  When we need to create a new resource, a single instance
	 * should be added to this set to enable it.
	 */
	private Set<Object> singletons = new HashSet<Object>();
	public static MongoConnection getDatabase (){
		return db;
	}
	/**
	 * Instantiates the resources and adds them to the singletons Set.
	 */
	public FarkleServerApplication() {
		singletons.add( new PingPongResource() );  // Example resource, to be removed later
		singletons.add(new UserRegistration());
		singletons.add( new AuthenticatorFilter() );  // Authentication filter
		singletons.add(new GameServlet());
		singletons.add(new SocketFilter());
		singletons.add(new FarkleDB());
		singletons.add(new UserService());
		singletons.add(db = new MongoConnection());

		key = MacProvider.generateKey();
	}
	
	/**
	 * @return The set of resource/filter objects for this application.
	 */
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	public static Key getKey(){
		return key;
		
	}
}
