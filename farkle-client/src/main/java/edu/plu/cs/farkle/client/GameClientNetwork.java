package edu.plu.cs.farkle.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class GameClientNetwork{
	private Session session;
 	
 	private Scanner scan;
    private static CountDownLatch latch;
    private String token;
    private Logger logger = Logger.getLogger(this.getClass().getName());
	public GameClientNetwork(String token){
 		this.token = token;
 		
        latch = new CountDownLatch(1);

        String dest = "ws://localhost:8080/farkle/game";
		WebSocketClient client = new WebSocketClient();
		GameClient socket = new GameClient();
	
		scan = new Scanner(System.in);
			
			
			try {
			client.start();
		
			
			URI echoUri = new URI(dest);
			
			
			ClientUpgradeRequest request = new ClientUpgradeRequest();
			request.setHeader("Authorization", "Bearer "+token);
			client.connect(socket, echoUri, request);
			
			ArrayList<Integer> dice = new ArrayList<Integer>();
			
			while(scan.hasNext()){
				String input = scan.nextLine();
				String[] split = input.split("\\s");
				for (int i = 3; i < 9; i++)
					dice.add(Integer.valueOf(split[i]));
				session = socket.getSession();
				sendJSON(split[0], split[1], split[2], new Dice(dice), 0, 0);
				dice.removeAll(dice);
			}
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public void sendJSON(String command, String name, String message, Dice dice,
			int score, int storedScore){
		ObjectMapper mapper = new ObjectMapper();
		ServerCommand cmd = new ServerCommand(command, name, message,dice, score, storedScore);
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
}
