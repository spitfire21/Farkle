package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main (String[] args) throws UnknownHostException, IOException{
		Scanner scan = new Scanner(System.in);
		Socket sock = null;
		String server = scan.nextLine();
		int port = scan.nextInt();
		
		try {
		    sock = new Socket(server, port);
		    PrintWriter out =
		        new PrintWriter(sock.getOutputStream(), true);
		    BufferedReader in =
		        new BufferedReader(
		            new InputStreamReader(sock.getInputStream()));
		    BufferedReader stdIn =
			        new BufferedReader(
			            new InputStreamReader(System.in));
		    
		    String userInput;
		    String serverInput;
		    while(true){
		    	if(in.ready()){
		    		serverInput = in.readLine();
		    		System.out.println("ECHO: " + serverInput);
		    		
		    	}
		    	if(stdIn.ready()) {
		    		userInput = scan.nextLine();
		    			out.println(userInput);
		        
		    	}
		    	
		    }
		    
		    
		
		} finally {
			
			sock.close();
			scan.close();
		}
	}
}
