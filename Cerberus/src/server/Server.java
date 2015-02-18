package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {

	@SuppressWarnings("resource")
	public void run() {

		int port = 5800;

		try {
			System.out.println("Server hosting on port: " + port);
			ServerSocket ss;
			ss = new ServerSocket(port);

			while (true) {
				Socket s = ss.accept();
				System.out.println("Connection established");
				Thread t = new Thread(new ServerThread(s));
				t.start();
			}
		} catch (Exception e) {
			System.out.println("System exception");
			e.printStackTrace();
		}
	}
}

class ServerThread implements Runnable {
	private Socket s;

	public ServerThread(Socket socket) {
		this.s = socket;
	}

	public void run() {
		String clientip;
		clientip = s.getInetAddress().toString();
		System.out.println("Connected to " + clientip);

		try {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(s.getInputStream());
			boolean reconnect = true;

			while (reconnect) {

				while (true) {
					String input = in.nextLine();

					if (input.equalsIgnoreCase("bye")) {
						reconnect = false;
						break;
					} else if (input.equalsIgnoreCase("good/center")) {

					} else if (input.equalsIgnoreCase("left")) {

					} else if (input.equalsIgnoreCase("right")) {

					} else if (input.equalsIgnoreCase("top")) {

					} else if (input.equalsIgnoreCase("bot")) {

					} else if (input.equalsIgnoreCase("top left")) {

					} else if (input.equalsIgnoreCase("top right")) {

					} else if (input.equalsIgnoreCase("bot left")) {

					} else if (input.equalsIgnoreCase("bot right")) {

					} else if (input.equalsIgnoreCase("bad")) {

					} else if (input.equalsIgnoreCase("reconnect")) {

					}
				}

				reconnect = true;

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Closed connection to" + clientip);
	}
}