package crypt.chat;

import java.net.Socket;
/*
 * This is in charge of keeping track of a single chat stream. A new ChatSession will be initialized for every stream.
 */

public class ChatSession {
	private Socket client;
	private String serverName;
	private String username;
	private String password;
	
	ChatSession(Socket s,  String server, String user, String pass)
	{
		this.client = s;
		this.serverName = server;
		this.username=user;
		this.password=pass;		
	}
	
	protected boolean logIn(String user, String pass)
	{
		
		//returns false if login fails
		//rturn true if login suceeds
	}
	
	protected boolean sendChat(String message)
	{
		//sends stuff to output stream
		this.client.getInputStream();
		
		
	}
}
