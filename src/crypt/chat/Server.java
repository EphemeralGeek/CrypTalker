package crypt.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

private String username;
private String password;
private String ipAddress;
private ArrayList<String> ipList = new ArrayList();

public class Server {

	public void Login(String user, String pass) {
		this.username = user;
		this.password = pass;
		try {
			InetAddress i = InetAddress.getLocalHost();
			this.ipAddress = i.getHostAddress();
			ipList.add(ipAddress);
			System.out.println(username + " connected from " + ip);
		
		} catch (Exception e) {}
	}


}

/*	serve = new ServerSocket(port);
	System.out.println("Congratulations you have started a server on port: "+serve.getLocalPort()+"\n The server can be found at the following IP adress: "+serve.getInetAddress());
	client=serve.accept();
	
	//makes sure that the client has showed up
	BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
	String temp = reader.readLine();
	if(temp.equals("Hello server"))
	{
		System.out.println()
	}else
	{
		System.out.println("Oops! Something went wrong. Please restart the program. Sorry about that! :(");
	}
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
*/
}
