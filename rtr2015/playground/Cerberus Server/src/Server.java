import java.net.*;
import java.util.*;
import java.io.*;

public class Server {

	public static void main(String [] args){
		
		int port = 1234;
		
		try
		{
			System.out.println("Server Up (Hopefully)");
			System.out.println("Listening on port " + port);
			ServerSocket ss;
			ss = new ServerSocket(port);
			Socket s;
			s = ss.accept();
			
			String client;
			client = s.getInetAddress().toString();
			System.out.println("Connected to " + client);
			
			Scanner in = new Scanner(s.getInputStream());
			PrintWriter out;
			out = new PrintWriter(s.getOutputStream(),true);
			
			out.println("YAY IT WORKED");
			out.println("Type get to test");
			
			while (true){
				String input = in.nextLine();
				if (input.equalsIgnoreCase("bye"))
					break;
				else if (input.equalsIgnoreCase("get"))
				{
					System.out.println("YAY IT WORKED LIKE COMPLETLY YAY!");
					System.out.println("Serving " + client);
					out.println("Andrew is nut smurt");
			}
				else
					out.println("Huh?");
			}
			out.println("Disconnecting");
			s.close();
			System.out.println("Connection closed to " + client);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
