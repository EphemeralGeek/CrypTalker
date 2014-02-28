package crypt.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientControll {
	private int defaultPort = 1995;
	private ArrayList<ChatSession> chats = new ArrayList<ChatSession>();
	
	public void sendObject(Object objectToSend)
	{
		//code a serialization method
		//send the stuff
	}
	public void sendString(String stringToSend)
	{
		//send the string
	}
	public void setServerName(String name)
	{
		String serverName = name;
	}
	public static void main(String args)
	{
		ClientControll c = new ClientControll();
		c.start();
	}
	public void start()
	{
		//TODO change this to a GUI
		Cli interact = new Cli();
		String ip = interact.getStringInput("Welcome to CryptTalk! What server would you like to coneect to?");
		/*
		 * if user wants to define port 
		 * client = new Socket(ip, userDefinedPort);
		 */
		client = new Socket(ip, defaultPort);
		
		
		String user = interact.getStringInput("What is the username you would like to use on "+this.serverName+"?");
		//String pass = interact.getStringInput("What is your password for "+this.serverName+"?");
		//LogIn(user, pass)
		ChatSession l = new ChatSession(client, user);
		chats.add(l);
	}
	
	
	//authenticates with the server
	PrintStream myPS = new PrintStream(client.getOutputStream());
	myPS.println("Hello server");
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	String temp = reader.readLine();
	if(temp.equals("Got something"))
	{
		System.out.println("Congrats you have an oponet!");
		numOfGames=Integer.parseInt(reader.readLine());
		player1.setMovesFirst(Boolean.parseBoolean(reader.readLine()));
	}
	else
	{
		System.out.println("Oops something went wrong. Restart the program and try again. Sorry about that :(");
	}
	player2.setSocket(client);
}
}
