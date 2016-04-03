package edu.plu.cs.farkle.client;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


//controller for the mainpage/victories

public class ClientMainPage{
	
	private String vList;
	private Client client;
	
	public ClientMainPage(){
		client = ClientBuilder.newClient();
	}
	
	public String requestVictors() throws JsonProcessingException, IOException{
		
		
		//Domain model
		//architecture
		//leader-board
		//rules
		//gamepage
		
		WebTarget webTarget = client.target("http://localhost:8080/farkle/victories");
		Invocation.Builder invocBuild =
				webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocBuild.get();
		
		System.out.println(response.getStatus());
		
		
		return null; 
		
	}
	
	
public void parseVictors(String vics) {
	System.out.println(vics);
}

public void setList(String v) {
	vList = v;
}

public String getList() {
	try {
		String v = this.requestVictors();
		this.parseVictors(v);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "null";
}
	




}
