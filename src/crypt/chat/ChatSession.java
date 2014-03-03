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
	
<<<<<<< HEAD
<<<<<<< HEAD
	ChatSession( String server, String user, String pass)
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
	
	protected void sendChat(String message)
	{
		//sends stuff to output stream
<<<<<<< HEAD
		this.client.getOutputStream();
=======
		this.client.getOutputStream().write(message.getBytes());
>>>>>>> 3c3ecc3b89bbc8cbbad34d88576af9d334fa87cf
		
		
	}
=======
=======
>>>>>>> cc38c0fb5191a57254a9c706ea1836814128e1f4
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
<<<<<<< HEAD
		return username;
	}	
=======
		
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
	
	
<<<<<<< HEAD
>>>>>>> cc38c0fb5191a57254a9c706ea1836814128e1f4
=======
>>>>>>> cc38c0fb5191a57254a9c706ea1836814128e1f4
>>>>>>> 3bcc21ff5be05543e4692d3a1cc5b1ba1a6b9c29
}


