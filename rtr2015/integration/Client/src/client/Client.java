package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		int port = 5800;
		boolean finish = false;
		Socket s = getSocket(port);
		Scanner sending = new Scanner(System.in);
		try {
			System.out.println("Connected on port " + port);
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out;
			out = new PrintWriter(s.getOutputStream(), true);
			// String quote = in.nextLine();
			// System.out.println(quote);
			// in.nextLine();
			// in.nextLine();
			while (true) {
				while (finish == false) {
					String done = in.nextLine();
					if (done.equalsIgnoreCase("done")) {
						finish = true;
					} else {
						System.out.println(in.nextLine());
					}
				}
				out.println(sending.nextLine());
				String done = "Not Done";
			}
			// s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Socket getSocket(int port) {
		Socket s;
		String host;
		InetAddress ip;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("What server do you want to connect to?");
			host = sc.nextLine();
			try {
				ip = InetAddress.getByName(host);
				s = new Socket(ip, port);
				return s;
			} catch (UnknownHostException e) {
				System.out.println("The Host is Unknown.");
			} catch (IOException e) {
				System.out.println("Network Error.");
			}
		}
	}
}
