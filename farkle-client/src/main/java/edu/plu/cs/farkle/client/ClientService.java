package edu.plu.cs.farkle.client;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ClientService {
	private Client client;
	private GameClient gameClient;
	private Response response;
	private String token;
	public ClientService(){
		client = ClientBuilder.newClient();
		
	}
	public String Register(String username, String password) throws JsonProcessingException, IOException{
		WebTarget target = client.target("http://localhost:8080/farkle/registration");
		//Invocation.Builder builder = target.request();

		
		Response response = target
	            
	            
	            
	            .request(MediaType.APPLICATION_JSON)
	           
	            .post(Entity.entity(new UserCredentials(username, password),  MediaType.APPLICATION_JSON));
		
		//String json = builder.get(String.class);
	            
		 String value = response.readEntity(String.class);
		 ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(value);
	        return node.get("response").asText();
	}
	public String Login(String username, String password){
		
				Response response = client.target("http://localhost:8080/farkle/login")

	            
	            .request(MediaType.APPLICATION_JSON)
	            
	            .post(Entity.entity(new UserCredentials(username, password),  MediaType.APPLICATION_JSON));
	            
		 String value = response.readEntity(String.class);
		 token = value;
		return value;
		
	}
	

}
