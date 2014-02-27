package crypt.chat;

import java.net.Socket;
import java.util.Scanner;
/*
 * This is in charge of keeping track of a single chat stream. A new ChatSession will be initialized for every stream.
 */

public class ChatSession {
	
	private Scanner input = new Scanner(System.in);
	private Socket client;
	private String serverName;
	private String username;
	private String password;
	
	private boolean inputtingLogIn = true;
	
	public ChatSession(Socket client, String serverName){
		
		logIn();
		this.client = client;
		this.serverName = serverName;
	}
	
	public void logIn(){
		
		System.out.println("Please input your username");
		username = input.nextLine().trim();
		
		while (inputtingLogIn){
			
			if (username.equals(null) || username.trim().length() == 0){
				System.out.println("Please input ");
				
			} else{
				break;
			}
		}
		
		
		
		System.out.println("Please input your password");
		password = input.nextLine().trim();
	}
	
	
}


