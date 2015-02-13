package imageclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		int port = 3000;
		int direction = 0;
		Socket s = getSocket(port);
		PrintWriter out;
		Scanner in;
		try {
			in = new Scanner(s.getInputStream());
			out = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] Could not read server input stream");
			return;
		}

		while (true) {
			out.println("centered");
			out.println("centered");
			System.out.println("test");
			String test = new String("");
			try {
				System.out.println("2");
				if (in.hasNextLine())
					test = in.next();
				System.out.println("3");
			} catch (Exception e) {
				System.out.println("[Error] Lost connection to server");
				break;
			}

			if (test.equals("end")) {
				System.out.println("Finished");
				break;
			}
		}

		try {
			s.close();
			in.close();
			System.out.println("finished");
		} catch (IOException ex) {
			System.out
					.println("[Error] Could not safely disconnect (Connection lost forcefully possibly");
		}
	}

	private static Socket getSocket(int port) {
		// TODO Auto-generated method stub
		Socket s;
		String host;
		while (true) {
			try {
				InetAddress ip = InetAddress.getByName("127.0.0.1");
				s = new Socket(ip, port);
				return s;
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("[Error] Could not find robot server");
				continue;

			} catch (IOException ex) {
				System.out.println("[Error] Generic network error");
				continue;
			}

		}
	}

}
