package edu.plu.cs.farkle.server.resource;

import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import edu.plu.cs.farkle.server.auth.Secured;

@WebServlet(urlPatterns="/farkle/game")

	
	public class GameServlet extends WebSocketServlet{
		
		@Override
		public void configure(WebSocketServletFactory factory) {
			  System.out.println("WORKING");
		      factory.register(GameServer.class);
			
		}

	
}
