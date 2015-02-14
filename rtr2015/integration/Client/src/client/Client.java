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
		int port = 3000;
		// Image Processing
		Socket s = getSocket(port);
		try {
			System.out.println("Connected on port " + port);
			PrintWriter out;
			out = new PrintWriter(s.getOutputStream(), true);
			String str = "";
			for (int i = 0; i < 1000; i++) {
				int r = new Random().nextInt(2);

				if (r == 0) {
					str = "Not Centered";
				} else if (r == 1) {
					str = "Centered";
				}

				out.println(str);
			}

			s.close();
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
			System.out.print("What Server do you want to connect to?");
			host = sc.nextLine();
			try {
				ip = InetAddress.getByName(host);
				s = new Socket(ip, port);
				return s;
			} catch (UnknownHostException e) {
				System.err.println("The Host is Unknown.");
			} catch (IOException e) {
				System.err.println("Network Error.");
			}
		}
	}
}
