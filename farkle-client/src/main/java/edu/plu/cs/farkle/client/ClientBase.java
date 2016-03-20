package edu.plu.cs.farkle.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import GUI.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

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
		return login.Login(username, password);
	}
	public void methodToCallBack() {
		// TODO Auto-generated method stub
		
	}

	
}

