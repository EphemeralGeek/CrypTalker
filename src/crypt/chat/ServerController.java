import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ServerController {
	
	private static ArrayList<Socket> connectionsArray = new ArrayList<Socket>();
	private static ArrayList<InputStream> inputStreamArray = new ArrayList<InputStream>();
	private static ArrayList<OutputStream> outputStreamArray = new ArrayList<OutputStream>();
	private static boolean threadExists = false;
	
	public static void main(String[] args) {
		while (true) {
			listen();
			
			ArrayList<String> recievedChat = null;
			
			try {
				recievedChat = recieve();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				send(recievedChat);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("we have hit an impass...");
		}
	}

	private static ArrayList<String> recieve() throws IOException {
		ArrayList<String> recievedChat = new ArrayList<String>();
		
		for (int i = 0; i < connectionsArray.size(); i++) {
			InputStream tempInputStream = connectionsArray.get(i).getInputStream();
			
			if (!inputStreamArray.contains(tempInputStream)) {
				inputStreamArray.add(tempInputStream);
			}
		}
		
		for (int i = 0; i < inputStreamArray.size(); i++) {
			byte[] tempByteArray = new byte[inputStreamArray.get(i).available()];
			inputStreamArray.get(i).read(tempByteArray);
			recievedChat.add(new String(tempByteArray));
		}
		
		return recievedChat;
	}
	
	private static void send(ArrayList<String> recievedChat) throws IOException {

		for (int i = 0; i < connectionsArray.size(); i++) {
			OutputStream tempOutputStream = connectionsArray.get(i).getOutputStream();
			
			if (!outputStreamArray.contains(tempOutputStream)) {
				outputStreamArray.add(tempOutputStream);
			}
		}
		
		for (int i = 0; i < outputStreamArray.size(); i++) {
			for (int j = 0; j < recievedChat.size(); j++) {
				outputStreamArray.get(i).write(recievedChat.get(j).getBytes());
			}
		}
	}
	
	private static void listen() {
		if (!threadExists) {
			new Thread(new ChatInstance()).start();
			threadExists = true;
		}
	}
	
	public static void addToConnections(Socket tempSocket) {
		connectionsArray.add(tempSocket);
	}
}
