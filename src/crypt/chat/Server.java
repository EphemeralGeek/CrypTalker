package crypt.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

public class Server {

	serve = new ServerSocket(port);
	System.out.println("Congratulations you have started a server on port: "+serve.getLocalPort()+"\nThe server can be found at the following IP adress: "+serve.getInetAddress());
	client=serve.accept();
	
	//makes sure that the client has showed up
	BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	String temp = reader.readLine();
	if(temp.equals("Hello server"))
	{
		System.out.println("Congrats you have an oponet!");
		PrintStream pushToSocket = new PrintStream(client.getOutputStream());
		pushToSocket.println("Got something");
		pushToSocket.println(numOfGames);
	}else
	{
		System.out.println("Oops! Something went wrong. Please restart the program. Sorry about that! :(");
	}
	player1.setSocket(client);
	//sets who moves first
	System.out.println("Do you want to move first? y/n");
	temp=input();
	PrintStream pushToSocket = new PrintStream(client.getOutputStream());
	if(temp.equalsIgnoreCase("y"))
	{
		player1.setMovesFirst(false);
		pushToSocket.println("true");
	}
	else
	{
		player1.setMovesFirst(true);
		pushToSocket.println("false");
	}
	
}
