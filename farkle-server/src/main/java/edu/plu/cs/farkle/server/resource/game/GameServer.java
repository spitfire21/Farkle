package edu.plu.cs.farkle.server.resource.game;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import edu.plu.cs.farkle.server.resource.game.Game.Player;

@WebSocket
public class GameServer {
	// Maps to hold, bind player with session
		static HashMap<Session, Player> map = new HashMap<Session, Player>();
		static HashMap<Integer, Game> games = new HashMap<Integer, Game>();
		// Logger to log events 
	    private Logger logger = Logger.getLogger(this.getClass().getName());
	    // counter that increments when games are created
	    static int gameCount = 0;
	    Game game;
	    // annotation for websockets
	    
	    @OnWebSocketConnect
	    public void onConnect(Session session) throws IOException {
	    	ServerCommand cmd = new ServerCommand("Connected", "", "You Connected", new Dice(), 0, 0);
			ObjectMapper mapper = new ObjectMapper();
			

			session.getRemote().sendString(mapper.writeValueAsString(cmd));
    		 System.out.println("Client Connected");
	        logger.info("Connected ... " + session.getLocalAddress());
	    }
	 
	    @OnWebSocketMessage
	    public void onText(Session session, String message) throws IOException {
	    	//TODO
	    	//CHECK FOR SINGLE PLAYER OR MULTIPLAYER
	    	//THEN CREATE GAME
	    	System.out.println(message);
	    	ServerCommand cmd = parseJson(message);
	    	if(cmd.getCommand().equals("MULTI")){
	    		createGame(session, Integer.parseInt(cmd.getMessage()));
	    	}
	    	
	    	Player player = null;
	    	
	    		// find player with session
	    			player = map.get(session);
	    			if (player!= null){
	    				// check command
	    				player.checkCommand(cmd);
	    			}
	    		
	    			
	    	
	        
	        
	    }
	 
	    private void createGame(Session session, int mult) throws IOException {
			
	    	// player that will be added to game
	    	 Player p;
	    	 // check if games are full
	    	 game = findGame(mult);
	    	 // create new player for game using session
	    	 p = game.new Player(session, session.getUpgradeRequest().getUserPrincipal().getName());
	    	 // add player to game and associate with map
	    	 game.addPlayer(p);
	    	 map.put(session, p);
			
		}

		@OnWebSocketClose
	    public void onClose(Session session, int status, String reason) {
	    	
	        logger.info(String.format("Session %s closed because of %s", reason));
	       session.close();
	    }
	    
	    
	    /***
	     * Method to find game for player, if game is full then create 
	     * a new game
	     * @return Game
	     */
	    private static Game findGame(int mult) {		
			// Find an existing game and return it
	    	// if mult 0 then no ai
	    	// if mult 1 then ai
	    	Game createGame;
	    	if(mult == 1){
			for (Game g : games.values()) {
				if (g.getStatus().equals("WAITING")) {
					return g;
				}
			}
			// Create new game
			createGame = new Game(gameCount++, 4);
			games.put(createGame.getID(), createGame);
	    	}else {
	    		createGame = new Game(gameCount++, 1);
				games.put(createGame.getID(), createGame);
	    	}
			return createGame;
		}
	    public ServerCommand parseJson(String command) {
			ObjectMapper mapper = new ObjectMapper();
			ServerCommand cmd= null;
			try {
				cmd = mapper.readValue(command, ServerCommand.class);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			 return cmd;

		}
	   

	    
	}


