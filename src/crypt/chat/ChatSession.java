package crypt.chat;

import java.net.Socket;
/*
 * This is in charge of keeping track of a single chat stream. A new ChatSession will be initialized for every stream.
 */

public class ChatSession {
	private Socket client;
	private String serverName;
}
