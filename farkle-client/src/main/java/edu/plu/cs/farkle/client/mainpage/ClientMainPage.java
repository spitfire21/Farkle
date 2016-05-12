package edu.plu.cs.farkle.client.mainpage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


//controller for the mainpage/victories

public class ClientMainPage{
	
	private String vList;
	private Client client;
	private String url;
	public ClientMainPage(){
		client = ClientBuilder.newClient();
		Properties prop = new Properties();
	    String fileName = "farkle.config";
	    InputStream is;
		try {
			is = new FileInputStream(fileName);
			prop.load(is);
			url = prop.getProperty("farkle.url");
		} catch (FileNotFoundException e) {
			System.out.println("Config File Missing");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Config File Missing");
			e.printStackTrace();
		}

	   
	}
	
	public String requestVictors() throws JsonProcessingException, IOException{
		
			
//		WebTarget webTarget = client.target("http://152.117.219.35:8080/farkle/victories");
		WebTarget webTarget = client.target("http://"+url+":8080/farkle/victories");
	
		Invocation.Builder invocBuild =
				webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocBuild.get();
		
		System.out.println(response.getStatus());
		
		return response.readEntity(String.class);
					
	}
	
	public String requestUVictors(String uName) throws JsonProcessingException, IOException {
		WebTarget webTarget = client.target("http://"+url+":8080/farkle/victories/user").queryParam("uName", uName );

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
	
	List<String> victors = new ArrayList<String>();
	
	/*for(int i=0;i<10;i++){
		if(vList.getVictors().size()<i)
			victors.add(i+1 + ". null: null");
		else 
			victors.add(i+1 + ". " + vList.getVictors().get(i));
	}*/
	
	return vList.getVictors();
	//return victors;
}
	
public String getURank(String uName) throws JsonParseException, JsonMappingException, IOException {
	String uV = this.requestUVictors(uName);
	Victories uVList = parseVictors(uV);
	
	System.out.println(uVList.getVictors().toString());
	
	return uVList.getVictors().get(0);
}

}
