package edu.plu.cs.farkle.client;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
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
		
			
		WebTarget webTarget = client.target("http://localhost:8080/farkle/victories");
		Invocation.Builder invocBuild =
				webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocBuild.get();
		
		System.out.println(response.getStatus());
		
		return response.readEntity(String.class);
					
	}
	
	
public Victories parseVictors(String vics) {
	ObjectMapper mapper = new ObjectMapper();
	try {
		return mapper.readValue(vics, Victories.class);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}	
}

public List<String> getList() throws JsonParseException, JsonMappingException, IOException {
	String v = this.requestVictors();
	Victories vList = parseVictors(v);
	return vList.getVictors();
}
	


}
