package edu.plu.cs.farkle.client;

import java.io.IOException;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;


/**
 * Simple client that connects to a websocket
 * @author Cody-Desktop
 *
 */
@WebSocket
	public class GameClient {
	 	Session session;
	 
	    @OnWebSocketConnect
	    public void onConnect(Session session) {
	    	 this.session = session;
	    	
	    	 
	    }
	 
	    @OnWebSocketMessage

	    public void onText(Session session, String message) throws IOException {
	    	System.out.println(message);
	  
	    }
	    public GameClient(){
	    	
	    }
	    public Session getSession(){
			return session;
	    	
	    }
}

	  
	    
	   
	 