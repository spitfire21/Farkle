package edu.plu.cs.farkle.client;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.websocket.ClientEndpointConfig;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;


/**
 * Simple client that connects to a websocket
 * @author Cody-Desktop
 *
 */
@WebSocket
	public class GameClient {
	 	private Session session;
	    private static CountDownLatch latch;
	    private String token;
	    private Logger logger = Logger.getLogger(this.getClass().getName());
	 
	    @OnWebSocketConnect
	    public void onConnect(Session session) {
	    	 this.session = session;
	    }
	 
	    @OnWebSocketMessage

	    public void onText(Session session, String message) throws IOException {
	    	System.out.println(message);
	    }
	    public void sendMessage(String str) {
			try {
				session.getRemote().sendString(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	    public GameClient(){
	    	
	    }
	 	public GameClient(String token){
	 		this.token = token;
	        latch = new CountDownLatch(1);

	        String dest = "ws://localhost:8080/farkle/game";
			WebSocketClient client = new WebSocketClient();
			GameClient socket = new GameClient();
				
				
				try {
				client.start();
			
				
				URI echoUri = new URI(dest);
				
				
				ClientUpgradeRequest request = new ClientUpgradeRequest();
				request.setHeader("Authorization", "Bearer "+token);
				client.connect(socket, echoUri, request);
			
		
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	
		
}
