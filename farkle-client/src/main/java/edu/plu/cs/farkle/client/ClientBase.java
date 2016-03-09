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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientBase 
{
	public static void main(String args[])
	{
		Client client = ClientBuilder.newClient();
		
		try
		{
			WebTarget endTarget = client.target("http://localhost:8901/farkle/FarkleGameServer"); // will need to be updated
				
			Invocation.Builder builder = endTarget.request();
			String response = builder.get(String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(response);
			
			builder = endTarget.request();
			builder = builder.header(HttpHeaders.AUTHORIZATION, "test");
			response = builder.get(String.class);
			
			mapper = new ObjectMapper();
			node = mapper.readTree(response);
			
			Form form = new Form();
	        form.param("name", "test");
	        Entity<Form> entity1 = Entity.form(form);
			Response response1 = client.target("http://localhost:8080/farkle/login")
		            
		            
		            
		            .request(MediaType.APPLICATION_JSON)
		            
		            .post(entity1);
		            
			 String value = response1.readEntity(String.class);
		        System.out.println(value);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Make sure that we always close the client.
			client.close();
		}
		
	}
}
