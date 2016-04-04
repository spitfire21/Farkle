package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import edu.plu.cs.farkle.server.auth.Secured;
import edu.plu.cs.farkle.server.resource.Game.Player;

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
	    	// player that will be added to game
	    	 Player p;
	    	 // check if games are full
	    	 game = findGame();
	    	 // create new player for game using session
	    	 p = game.new Player(session, session.getUpgradeRequest().getUserPrincipal().getName());
	    	 // add player to game and associate with map
    		 game.addPlayer(p);
    		 map.put(session, p);
    		 
    		 System.out.println("Client Connected");
	        logger.info("Connected ... " + session.getLocalAddress());
	    }
	 
	    @OnWebSocketMessage
	    public void onText(Session session, String message) throws IOException {
	    	
	    	Player player = null;
	    	
	    		// find player with session
	    			player = map.get(session);
	    			if (player!= null)
	    				// check command
	    				player.test(message);
	    		
	    	
	    	
	        
	        
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
	    private static Game findGame() {		
			// Find an existing game and return it
			for (Game g : games.values()) {
				if (g.getStatus().equals("WAITING")) {
					return g;
				}
			}
			// Create new game
			Game createGame = new Game(gameCount++);
			games.put(createGame.getID(), createGame);
			return createGame;
		}

	    
	}


