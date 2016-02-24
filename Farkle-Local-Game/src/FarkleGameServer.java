import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FarkleGameServer {
	private static Map<Integer, Game> games;
	static int gameCount;
	public static void main(String[] args) throws IOException {
	    games = new HashMap<Integer, Game>();
		boolean localPlay = true;
		Game game;
		
		if (localPlay){
		ServerSocket listener = new ServerSocket(8901);
		System.out.println("Server Running: Waiting for Clients");
			  try {
				  
				  
		            
		            	Socket aPlayer;
						while((aPlayer = listener.accept())!=null){
		            		 game = findGame();
		            		 game.addPlayer(game.new Player(aPlayer));
		            		 System.out.println("Client Connected");
		            		 
		            	}
		               
		               
		                
		                
		               
		                
		                
		                	
		                
		            
		        } finally {
		            listener.close();
		        }
		}

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
