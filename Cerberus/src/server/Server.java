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
						//stop strafe
						//start moving forward until ultrasonic is in range

					} else if (input.equalsIgnoreCase("left")) {
						//keep going left

					} else if (input.equalsIgnoreCase("right")) {
						//go right
					} else if (input.equalsIgnoreCase("top")) {
						//equal to center
					} else if (input.equalsIgnoreCase("bot")) {
						// equal to center
					} else if (input.equalsIgnoreCase("top left")) {
						// equal to left
					} else if (input.equalsIgnoreCase("top right")) {
						// equal to right
					} else if (input.equalsIgnoreCase("bot left")) {
						// equal to left
					} else if (input.equalsIgnoreCase("bot right")) {
						// equal to right
					} else if (input.equalsIgnoreCase("bad")) {
						// keep moving
					} else if (input.equalsIgnoreCase("reconnect")) {
						// reconnects the client
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