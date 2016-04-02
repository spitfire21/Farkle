package edu.plu.cs.farkle.client;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import GUI.GUI;

public class ClientBase implements CallBack 
{
	
	private String token;
	private ClientService login;
	private GUI gui;
	private String name;
	//TODO setup other user preferences that we need to get from DB
	public ClientBase(GUI frame){
		this.gui = frame;
		gui.registerCallback(this);
		login = new ClientService();
	}
	public String createAccount(String username, String password){
		String status = "";
		try {
			//TODO parse JSON
			
			
		status = login.Register(username, password);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		return name;
	}

	
}

