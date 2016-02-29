package edu.plu.cs.farkle.client;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

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
	 	private static Session session;
	    private static CountDownLatch latch;
	 
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
	    
	
	    public static void main(String[] args) throws Exception {
	        latch = new CountDownLatch(1);
	 
	        String dest = "ws://localhost:8080/game";
			WebSocketClient client = new WebSocketClient();
			GameClient socket = new GameClient();
				
				
				client.start();
				URI echoUri = new URI(dest);
				ClientUpgradeRequest request = new ClientUpgradeRequest();
				client.connect(socket, echoUri, request);
				Thread.sleep(100);
				//socket.sendMessage("ROLL");
				Scanner scan = new Scanner(System.in);
				String input;
				while((input = scan.nextLine())!=null){
					session.getRemote().sendString(input);
					
				}
			

	        
	    }
	
		
}
