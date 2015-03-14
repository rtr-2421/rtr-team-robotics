package client;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class Client {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static String serverIP = "";

	public static void main(String[] args) {

		int port = 5800;
		boolean finish = false;
		Socket s = getSocket(port);

		try {
			System.out.println("Connected on port " + port);
			PrintWriter out;
			out = new PrintWriter(s.getOutputStream(), true);

			while (true) {

				boolean maintainedConnection = true;
				finish = false;

				while (!finish) {

					out.println(getLocation());
					out.println("bye");
					finish = false;

				}

				if (!maintainedConnection) {
					s = reconnect(serverIP, port);
					out.println("reconnect");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			s = reconnect(serverIP, port);
		}
	}

	private static Socket getSocket(int port) {
		Socket s;
		String host;
		InetAddress ip;
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
		while (true) {
			// System.out.print("What server do you want to connect to?");
			//Do not use PI ip address
			// Need to change IP address to RoboRio's IP Address if name doesn't resolve
			host = "roborio-2421.local/";
			try {
				ip = InetAddress.getByName(host);
				s = new Socket(ip, port);
				serverIP = host;
				return s;
			} catch (UnknownHostException e) {
				System.out.println("The Host is Unknown.");
			} catch (IOException e) {
				System.out.println("Network Error.");
			}
		}
	}

	private static Socket reconnect(String host, int port) {
		Socket s;
		InetAddress ip;
		while (true) {
			try {
				ip = InetAddress.getByName(host);
				s = new Socket(ip, port);
				System.out.println("Reconnecting to " + host + ":" + port);
				return s;
			} catch (UnknownHostException e) {
				System.out.println("The Host is Unknown.");
			} catch (IOException e) {
				System.out.println("Network Error.");
			}
		}
	}

	private static String getLocation() {

		Scalar low = new Scalar(20, 100, 100);
		Scalar high = new Scalar(40, 255, 255);

		System.out.println("Successfully built");

		while (true) {
			// t.run();
			BufferedImage i = null;
			while (true) {
				try {
					i = ImageIO.read(new URL(
							"http://10.24.21.11/jpg/1/image.jpg"));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Cannot connect - Bad URL");
					continue;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Cannot connect - IOException");
					continue;
				} catch (Exception ex) {
					System.out.println("Cannot connect to robot");
					continue;
				}
				break;
			}
			byte[] data = ((DataBufferByte) i.getRaster().getDataBuffer())
					.getData();
			Mat frame = new Mat(i.getHeight(), i.getWidth(), CvType.CV_8UC3);
			frame.put(0, 0, data);
			Highgui.imwrite("camera.jpg", frame);

			// c.run();

			Mat imgOrg = Highgui.imread("camera.jpg");
			Mat imgHSV = new Mat();
			Imgproc.cvtColor(imgOrg, imgHSV, Imgproc.COLOR_BGR2HSV_FULL);
			Mat imgThresholded = new Mat();
			Core.inRange(imgHSV, low, high, imgThresholded);
			Imgproc.erode(imgThresholded, imgThresholded, new Mat());
			Imgproc.dilate(imgThresholded, imgThresholded, new Mat());

			List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
			Rect bound = new Rect();
			double area = 0;
			Imgproc.findContours(imgThresholded, contours, new Mat(),
					Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

			for (int b = 0; b < contours.size(); b++) {
				double a = Imgproc.contourArea(contours.get(b), false);
				if (a > area) {
					area = a;
					bound = Imgproc.boundingRect(contours.get(b));
				}
			}

			// ANDREW
			// double mid = (bound.x + (bound.x + bound.width)) / 2;
			// double Ultra = 12;
			// 12 is replaced with the distance from the Ultrasonic sensor
			Imgproc.cvtColor(imgThresholded, imgThresholded,
					Imgproc.COLOR_BayerBG2RGB);

			Imgproc.drawContours(imgOrg, contours, -1, new Scalar(0, 255, 0), 3);

			Point boundCntr = new Point(bound.x + bound.width / 2, bound.y
					+ bound.height / 2);

			// JOSH
			// Boxes for each section of the screen
			Rect rectCenter = new Rect(new Point(imgOrg.width() / 3,
					imgOrg.height() / 3), new Point(2 * imgOrg.width() / 3,
					2 * imgOrg.height() / 3));
			Rect rectLeft = new Rect(new Point(0, imgOrg.height() / 3),
					new Point(imgOrg.width() / 3, 2 * imgOrg.height() / 3));
			Rect rectRight = new Rect(new Point(2 * imgOrg.width() / 3,
					imgOrg.height() / 3), new Point(imgOrg.width(),
					2 * imgOrg.height() / 3));
			Rect rectTop = new Rect(new Point(imgOrg.width() / 3, 0),
					new Point(2 * imgOrg.width() / 3, imgOrg.height() / 3));
			Rect rectBot = new Rect(new Point(imgOrg.width() / 3,
					2 * imgOrg.height() / 3), new Point(2 * imgOrg.width() / 3,
					imgOrg.height()));
			Rect rectTopLeft = new Rect(new Point(0, 0), new Point(
					imgOrg.width() / 3, imgOrg.height() / 3));
			Rect rectTopRight = new Rect(new Point(2 * imgOrg.width() / 3, 0),
					new Point(imgOrg.width(), imgOrg.height() / 3));
			Rect rectBottomLeft = new Rect(
					new Point(0, 2 * imgOrg.height() / 3), new Point(
							imgOrg.width() / 3, imgOrg.height()));
			Rect rectBottomRight = new Rect(new Point(2 * imgOrg.width() / 3,
					2 * imgOrg.height() / 3), new Point(imgOrg.width(),
					imgOrg.height()));

			if (area == 0) {
				return "bad";
			} else if (bound.contains(new Point(imgOrg.width() / 2, imgOrg
					.height() / 2)) || rectCenter.contains(boundCntr)) {
				// if(contours.contains(new Point(imgOrg.width()/2,
				// imgOrg.height()/2))){

				return "Good/Center";
			} else if (rectLeft.contains(boundCntr)) {
				return "left";
			} else if (rectRight.contains(boundCntr)) {
				return "right";
			} else if (rectTop.contains(boundCntr)) {
				return "top";
			} else if (rectBot.contains(boundCntr)) {
				return "bot";
			} else if (rectTopLeft.contains(boundCntr)) {
				return "top left";
			} else if (rectTopRight.contains(boundCntr)) {
				return "top right";
			} else if (rectBottomLeft.contains(boundCntr)) {
				return "bot left";
			} else if (rectBottomRight.contains(boundCntr)) {
				return "bot right";
			}

			return "bad";

			// probably not needed, replaced by josh code
			// if (bound.contains(new Point(imgOrg.width() / 2, imgOrg.height()
			// / 2))) {
			// // if(contours.contains(new Point(imgOrg.width()/2,
			// // imgOrg.height()/2))){
			// System.out.println("Good");

			// } else {

			// System.out.println("bad");
			// }

			// andrew
			// while (Ultra >= 12) {
			// if (mid >= 330) {
			// // Put motor strafe Right here
			// System.out.println("Move Right");
			// } else if (mid <= 310) {
			// // motor strafe left here
			// System.out.println("Move Left");
			// } else if (mid >= 310 & mid <= 330) {
			// // Motor forward here
			// System.out.println("Centered; Move Forward");
			// }
			// }

			// NOT ANDREW

			/*
			 * Draws to screen
			 */

			// debug rectangles
			// Core.rectangle(imgOrg, rectTopLeft.tl(), rectTopLeft.br(),
			// new Scalar(0, 153, 255));
			// Core.rectangle(imgOrg, rectTop.tl(), rectTop.br(), new Scalar(0,
			// 153, 255));
			// Core.rectangle(imgOrg, rectTopRight.tl(), rectTopRight.br(),
			// new Scalar(0, 153, 255));
			// Core.rectangle(imgOrg, rectLeft.tl(), rectLeft.br(), new
			// Scalar(0,
			// 153, 255));
			// Core.rectangle(imgOrg, rectCenter.tl(), rectCenter.br(),
			// new Scalar(0, 153, 255));
			// Core.rectangle(imgOrg, rectRight.tl(), rectRight.br(), new
			// Scalar(
			// 0, 153, 255));
			// Core.rectangle(imgOrg, rectBottomLeft.tl(), rectBottomLeft.br(),
			// new Scalar(0, 153, 255));
			// Core.rectangle(imgOrg, rectBot.tl(), rectBot.br(), new Scalar(0,
			// 153, 255));
			// Core.rectangle(imgOrg, rectBottomRight.tl(),
			// rectBottomRight.br(),
			// new Scalar(0, 153, 255));
			//
			// if (area != 0)
			// Core.rectangle(imgOrg, new Point(boundCntr.x - 3,
			// boundCntr.y - 3), new Point(boundCntr.x + 3,
			// boundCntr.y + 3), new Scalar(255, 255, 204));

			// Highgui.imwrite(filename, imgOrg);
		}
	}
}