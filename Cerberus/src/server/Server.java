package server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.usfirst.frc2421.Cerberus.subsystems.Drive;

public class Server implements Runnable {

	public void run() {

		int port = 3000;

		Command cmd = new Command();

		try {
			System.out.println("Listening on port " + port);
			ServerSocket ss = new ServerSocket(port);
			Thread t;

			while (true) {
				Socket s = ss.accept();
				t = new Thread(new CommandThread(s, cmd));

				System.out.println("Connection established");

				t.start();
			}
		} catch (Exception e) {

		}
	}
}

class CommandThread implements Runnable {

	private Socket s;
	private Command cmd;

	public CommandThread(Socket s, Command cmd) {
		this.s = s;
		this.cmd = cmd;
	}

	public void run() {

		String client = s.getInetAddress().toString();
		System.out.println("Connected to " + client);

		try {
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

			while (true) {
				String input = in.nextLine();

				if (!input.equals("centered")) {
					break;
				} else if (input.equals("centered")) {
					System.out.println("Good");
				}
			}

			s.close();
		} catch (Exception e) {

		}
	}
}

class Command extends Drive {

	/*
	 * need to code motor methods need to code sensors
	 */

	public void moveMotorFrontLeft(double speed) {
		setSpeedFrontLeftMotor(speed);
	}

	public void moveMotorBackLeft(double speed) {
		setSpeedBackLeftMotor(speed);
	}

	public void moveMotorFrontRight(double speed) {
		setSpeedFrontRightMotor(speed);
	}

	public void moveMotorBackRight(double speed) {
		setSpeedBackRightMotor(speed);
	}

	public void strafeRight() {

	}

	public void strafeLeft() {

	}

	public void setAllMotorsForward(double speed) {

	}

	public void testRange() {
		if (getUltRange() < .5) {
			setAllMotorsToSpeed(0.0);
			// need motors and code for tote lift
		}
	}
}