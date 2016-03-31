package edu.plu.cs.farkle.client;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;

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
		try {
			//TODO parse JSON
			login.Register(username, password);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "yes";
	}
	public String login(String username, String password){
		name = username;
		return token = login.Login(username, password);
	}
	
	@Override
	public String getToken() {
		
		return token;
	}

	
}

