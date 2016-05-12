package edu.plu.cs.farkle.client.account;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;

import edu.plu.cs.farkle.client.gui.GUI;

public class ClientBase implements CallBack 
{
	
	private String token;
	private ClientService login;
	private GUI gui;
	private String name;
	
	public ClientBase(GUI frame){
		this.gui = frame;
		gui.registerCallback(this);
		login = new ClientService();
	}
	public String createAccount(String username, String password){
		String status = "";
		try {	
			
		status = login.Register(username, password);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	public String login(String username, String password){
		name = username;
		return token = login.Login(username, password);
	}
	
	@Override
	public String getToken() {
		
		return token;
	}
	@Override
	public String getName() {
		
		return name;
	}

	
}

