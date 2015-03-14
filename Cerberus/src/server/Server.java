package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.usfirst.frc2421.Cerberus.commands.LiftTote;
import org.usfirst.frc2421.Cerberus.commands.LowerTote;
import org.usfirst.frc2421.Cerberus.subsystems.Drive;

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

			Drive drive = new Drive();

			while (reconnect) {

				while (true) {
					String input = in.nextLine();
					// MUST
					// CHECK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					double curx = 1, cury = 0; // Assuming that we're starting a
												// right strafe

					if (input.equalsIgnoreCase("bye")) {
						reconnect = false;
						break;
					} else if (input.equalsIgnoreCase("good/center")) {
						// stop strafe
						// start moving forward until ultrasonic is in range
						drive.setDirection(0, 0);
						curx = 0;
						cury = 0;
						drive.setDirection(0, 1);
						if (drive.getUltRange() < 1.5
								&& drive.getUltRange() > 0) {
							drive.setDirection(0, 0);
							LiftTote ut = new LiftTote();
							LowerTote dt = new LowerTote();
							
						}

					} else if (input.equalsIgnoreCase("left")) {
						// keep going left
						drive.setDirection(-1, 0);
						curx = -1;
						cury = 0;

					} else if (input.equalsIgnoreCase("right")) {
						// go right
						drive.setDirection(1, 0);
						curx = 1;
						cury = 0;
					} else if (input.equalsIgnoreCase("top")) {
						// equal to center
						drive.setDirection(0, 0);
						curx = 0;
						cury = 0;
						drive.setDirection(0, 1);
						if (drive.getUltRange() < 1.5
								&& drive.getUltRange() > 0) {
							drive.setDirection(0, 0);
							LiftTote ut = new LiftTote();
							LowerTote dt = new LowerTote();
							
						}
					} else if (input.equalsIgnoreCase("bot")) {
						// equal to center
						drive.setDirection(0, 0);
						curx = 0;
						cury = 0;
						drive.setDirection(0, 1);
						if (drive.getUltRange() < 1.5
								&& drive.getUltRange() > 0) {
							drive.setDirection(0, 0);
							LiftTote ut = new LiftTote();
							LowerTote dt = new LowerTote();
							
						}
					} else if (input.equalsIgnoreCase("top left")) {
						// equal to left
						drive.setDirection(-1, 0);
						curx = -1;
						cury = 0;
					} else if (input.equalsIgnoreCase("top right")) {
						// equal to right
						drive.setDirection(1, 0);
						curx = 1;
						cury = 0;
					} else if (input.equalsIgnoreCase("bot left")) {
						// equal to left
						drive.setDirection(-1, 0);
						curx = -1;
						cury = 1;
					} else if (input.equalsIgnoreCase("bot right")) {
						// equal to right
						drive.setDirection(1, 0);
						curx = 1;
						cury = 0;
					} else if (input.equalsIgnoreCase("bad")) {
						// keep moving
						drive.setDirection(curx, cury);
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