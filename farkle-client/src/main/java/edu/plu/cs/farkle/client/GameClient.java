package edu.plu.cs.farkle.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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


 	
 		private Scanner scan;
 		private static CountDownLatch latch;
 		private String token;
 		private Logger logger = Logger.getLogger(this.getClass().getName());
 		private Player player;
	 	private Session session;
	 	private ServerCommand command;
	 	private GUICallBack callBack;
	 
	    @OnWebSocketConnect
	    public void onConnect(Session session) {
	    	 this.session = session;
	    	
	    	 
	    }
	 
	    @OnWebSocketMessage

	    public void onText(Session session, String message) throws IOException {
	    	latch.countDown();
	    	ObjectMapper mapper = new ObjectMapper();
	    	
	    	
	    	System.out.println(message);
	    	command = mapper.readValue(message, ServerCommand.class);
//	    	 if(player==null)
//	    		 player = new Player(command);
	    	if(command.getName().equals(player.getName())){
	    		player.parseCommand(command);
	    		callBack.updateStatus(command);
	    	}else {
	    		Player opponent = new Player();
	    		opponent.setName(command.getName());
	    		opponent.parseCommand(command);
	    		player.addOpponent(command.getName(), opponent);
	    	}
	    	
	    	//TODO Callback stuff for the game
	    	
	  
	    }
	    public GameClient(String name, GUICallBack callBack){
	    	this.callBack = callBack;
	    	player = new Player();
	    	player.setName(name);
	    	
	    }
	   
	    
	    
	    
	    	public GameClient(String token, String name, GUICallBack callBack){
	    		 
	     		this.token = token;
	     		
	            latch = new CountDownLatch(1);

	            String dest = "ws://localhost:8080/farkle/game";
	    		WebSocketClient client = new WebSocketClient();
	    		GameClient socket = new GameClient(name, callBack);
	    		
	    		scan = new Scanner(System.in);
	    			
	    			
	    			try {
	    			client.start();
	    		
	    			
	    			URI echoUri = new URI(dest);
	    			
	    			
	    			ClientUpgradeRequest request = new ClientUpgradeRequest();
	    			request.setHeader("Authorization", "Bearer "+token);
	    			client.connect(socket, echoUri, request);
	    			
	    			
	    		//	ArrayList<Integer> dice = new ArrayList<Integer>();
	    			latch.await();
	    			session = socket.getSession();
	    			player = socket.player;
	    			
//	    			while(scan.hasNext()){
//	    				String input = scan.nextLine();
//	    				String[] split = input.split("\\s");
//	    				for (int i = 3; i < 9; i++)
//	    					dice.add(Integer.valueOf(split[i]));
//	    				
//	    				
//	    				sendJSON(split[0], split[1], split[2], new Dice(dice), 0, 0);
//	    				dice.removeAll(dice);
//	    				
//	    			}
	    	
	    			} catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	        }
	    private Session getSession() {
				// TODO Auto-generated method stub
				return session;
			}

		public void sendMessage(String str) {
	    	try {
	    		System.out.println(str);
	    		
	    		session.getRemote().sendString(str);
	    		
	    		
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
		public String getPlayerName(){
			return player.getName();
		}
		public int getScore(){
			return player.getTotalScore();
		}
		public int getStoredScore(){
			return player.getStoredScore();
		}
		public ArrayList<Integer> getDice() {
			return player.getDice();
			
		}
		public String getOppenentScore(){
			return player.getOppenentScore();
		}
	    	
	    	public void sendJSON(String command, String name, String message, ArrayList<Integer> storeData,
	    			int score, int storedScore){
	    		ObjectMapper mapper = new ObjectMapper();
	    		ServerCommand cmd = new ServerCommand(command, name, message,new Dice(storeData), score, storedScore);
	    		try {
	    		sendMessage(mapper.writeValueAsString(cmd));
	    	} catch (JsonGenerationException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} catch (JsonMappingException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    		
	    		
	    	
	    }

			public String getError() {
				// TODO Auto-generated method stub
				return player.getStatus();
			}

			
	    }


	  
	    
	   
	 