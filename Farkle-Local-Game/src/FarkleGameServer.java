import java.io.IOException;
import java.net.ServerSocket;

public class FarkleGameServer {
	
	public static void main(String[] args) throws IOException {
		boolean localPlay = true;
		Game.Player[] players = new Game.Player[3];
		if (localPlay){
		ServerSocket listener = new ServerSocket(8901);
		System.out.println("Server Running: Waiting for Clients");
			  try {
		            while (true) {
		                Game game = new Game();
		                for(int i = 0; i < players.length; i++){
		                	players[i] = game.new Player(listener.accept(), i);
		                	System.out.println("Client Connected");
		                }
		                for(int i = 0; i < players.length; i++){
		                	for (int y = 0; y < players.length; y++ ){
		                		if(players[i].getPlayerNumber() != y){
		                			
		                			players[i].addOpponent(players[y]);
		                		}
		                	}
		                }
		               
		                game.currentPlayer = players[0];
		                for(int i = 0; i < players.length; i++){
		                	players[i].start();
		                }
		            }
		        } finally {
		            listener.close();
		        }
		}

	}

}
