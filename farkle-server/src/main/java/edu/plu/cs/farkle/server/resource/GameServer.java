package edu.plu.cs.farkle.server.resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;




import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import edu.plu.cs.farkle.server.resource.Game.Player;

@WebSocket
public class GameServer {
		static Map<Game, Player> map = new HashMap<Game, Player>();
		static HashMap<Integer, Game> games = new HashMap<Integer, Game>();
	    private Logger logger = Logger.getLogger(this.getClass().getName());
	    static int gameCount = 0;
	    Game game;
	    @OnWebSocketConnect
	    public void onConnect(Session session) throws IOException {
	    	 Player p;
	    	 game = findGame();
	    	 p = game.new Player(session);
    		 game.addPlayer(p);
    		 map.put(game, p);
    		 System.out.println("Client Connected");
	        logger.info("Connected ... " + session.getLocalAddress());
	    }
	 
	    @OnWebSocketMessage
	    public void onText(Session session, String message) throws IOException {
	    	System.out.println(message);
	    	Player player = null;
	    	for (Player p : map.values()){
	    		if(p.session.equals(session)){
	    			p.checkCommand(message);
	    		}
	    	}
	    	
	        
	        
	    }
	 
	    @OnWebSocketClose
	    public void onClose(Session session, int status, String reason) {
	        logger.info(String.format("Session %s closed because of %s", reason));
	    }
	    
	    
	    
	    private static Game findGame() {		
			// Find an existing game and return it
			for (Game g : games.values()) {
				if (g.status.equals("WAITING")) {
					return g;
				}
			}
			
			Game createGame = new Game(gameCount++);
			games.put(createGame.name, createGame);
			return createGame;
		}

	    
	}


