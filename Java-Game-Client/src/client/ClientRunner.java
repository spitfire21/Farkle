import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

//A very tentative class that allows the client to interface
// with a large database. Since the database has not been completed yet, this represents
// somewhat of a patchwork job utilizing Wolff's provided code as a base to build upon
public class ClientRunner 
{
	public static void main(String args[])
	{
		Client client = ClientBuilder.newClient();
		
		try
		{
			WebTarget target = client.target("http://localhost:8901/farkle/ping"); //update as needed
			
			Invocation.Builder build = target.request(); //will need to set up with authorization cross-checked with server in question
			String serverResponse = build.get(String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(serverResponse);
			
			Builder builder = target.request();
			builder = builder.header(HttpHeaders.AUTHORIZATION, "test");
			serverResponse = builder.get(String.class);
			
			mapper = new ObjectMapper();
			node = mapper.readTree(serverResponse);
			
			Form form = new Form();
			form.param("name", "test");
			Entity<Form> entity1 = Entity.form(form);
			Response response1 = client.target("http://localhost:8901/farkle/login") // replace with database directory
		            
		            
		            
		            .request(MediaType.APPLICATION_JSON)
		            
		            .post(entity1);
		            
			 String value = response1.readEntity(String.class);
		        System.out.println(value);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred: ");
			e.printStackTrace();
		}
		finally
		{
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