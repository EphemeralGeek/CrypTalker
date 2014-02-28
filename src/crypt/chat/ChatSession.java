package crypt.chat;

import java.io.IOException;
import java.io.InputStream;
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
	
	public String receive(){
		
		InputStream i;
		try {
			i = this.client.getInputStream();
		} catch (IOException e1) {
			return "false";
		}
		
		byte[] buffer = new byte[100];
		try {
			i.read(buffer);
		} catch (IOException e) {
			return "false";
		}
		try {
			i.close();
		} catch (IOException e) {
			return "false";
		}
		
		String data = new String(buffer);
		return data;
		// if no new data, string = "false", else "data"
	}
	
	public String logIn(){
		
		System.out.println("Please input your username");
		username = input.nextLine().trim();
		return username;
	}	
}


