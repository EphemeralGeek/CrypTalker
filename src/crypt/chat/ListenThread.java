import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ListenThread implements Runnable{

	@Override
	public void run() {
		Socket tempSocket = null;
		try {
			tempSocket = listen();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (tempSocket != null) {
			ServerController.addToConnections(tempSocket);
		}
	}
	
	
	private Socket listen() throws IOException {
		ServerSocket listeningSocket = new ServerSocket(1995);
		Socket foundSocket = listeningSocket.accept();
		listeningSocket.close();
		return foundSocket;
	}
}