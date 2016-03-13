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
import org.codehaus.jackson.map.ObjectMapper;

/**
 * A simple example client program, not to be used in the final product.
 *
 * Issues a GET to /farkle/ping and expects a JSON object back.
 */
public class PingPongClient {

	public static void main(String[] args) {
		
		// Create a new HTTP client object
		Client client = ClientBuilder.newClient();

		try {
			// The target URL
			WebTarget target = client.target("http://localhost:8080/farkle/ping");

			// Attempt a request without the Authorization header
			Invocation.Builder builder = target.request();
			String response = builder.get(String.class);

			// We expect the response to be JSON, so use the ObjectMapper to
			// parse.
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response);

			System.out.println("Response without Authorization header: ");
			printResponse(node);

			// Attempt a second request with the Authorization header
			builder = target.request();
			builder = builder.header(HttpHeaders.AUTHORIZATION, "test");
			response = builder.get(String.class);

			// We expect the response to be JSON, so use the ObjectMapper to
			// parse.
			mapper = new ObjectMapper();
			node = mapper.readTree(response);

			System.out.println("\nResponse with Authorization header: ");
			printResponse(node);
			
	      
	        
			Response response1 = client.target("http://localhost:8080/farkle/registration")
		            
		            
		            
		            .request(MediaType.APPLICATION_JSON)
		            
		            .post(Entity.entity(new UserCredentials("Jordan", "TED"),  MediaType.APPLICATION_JSON));
		            
			 String value = response1.readEntity(String.class);
		        System.out.println(value);
		        
		        Response response2 = client.target("http://localhost:8080/farkle/login")
			            
			            
			            
			            .request(MediaType.APPLICATION_JSON)
			            
			            .post(Entity.entity(new UserCredentials("Jordan", "TED"),  MediaType.APPLICATION_JSON));
			            
				 String value1 = response2.readEntity(String.class);
			        System.out.println(value1);
				
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Make sure that we always close the client.
			client.close();
		}
	
	 
		
	}
	
	public static void printResponse( JsonNode node )
	{
		System.out.println("JSON response:");
		System.out.println("-------------------------------------------------------------");
		System.out.printf(" response field:      %s\n", node.get("response").asText());
		System.out.printf(" authenticated field: %s\n\n", node.get("authenticated").asText());
		System.out.printf(" Raw JSON: %s\n", node.toString());
		System.out.println("-------------------------------------------------------------");
	}

}
