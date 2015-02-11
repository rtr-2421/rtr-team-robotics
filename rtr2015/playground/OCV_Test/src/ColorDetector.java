import java.util.ArrayList;
import java.util.List;

import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.*;

public class ColorDetector implements Runnable {

	private String filename;
	private Scalar low = new Scalar(20, 100, 100);
	private Scalar high = new Scalar(40, 255, 255);

	public ColorDetector(String filename) {
		this.filename = filename;
	}

	public void run() {

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
		
		//ANDREW
		double mid = (bound.x + (bound.x + bound.width)) / 2;
		double Ultra = 12;
		//12 is replaced with the distance from the Ultrasonic sensor
		Imgproc.cvtColor(imgThresholded, imgThresholded,
				Imgproc.COLOR_BayerBG2RGB);

		Imgproc.drawContours(imgOrg, contours, -1, new Scalar(0, 255, 0), 3);

		
		Point boundCntr = new Point(bound.x + bound.width/2, bound.y + bound.height/2);
		
		//JOSH
		//Boxes for each section of the screen
		Rect rectCenter = new Rect(new Point(imgOrg.width()/3, imgOrg.height()/3), new Point(2*imgOrg.width()/3, 2*imgOrg.height()/3));
		Rect rectLeft = new Rect(new Point(0, imgOrg.height()/3), new Point(imgOrg.width()/3, 2*imgOrg.height()/3));
		Rect rectRight = new Rect(new Point(2*imgOrg.width()/3, imgOrg.height()/3), new Point(imgOrg.width(), 2*imgOrg.height()/3));
		Rect rectTop = new Rect(new Point(imgOrg.width()/3, 0), new Point(2*imgOrg.width()/3, imgOrg.height()/3));
		Rect rectBot = new Rect(new Point(imgOrg.width()/3, 2*imgOrg.height()/3), new Point(2*imgOrg.width()/3, imgOrg.height()));
		Rect rectTopLeft = new Rect(new Point(0,0), new Point(imgOrg.width()/3, imgOrg.height()/3));
		Rect rectTopRight = new Rect(new Point(2*imgOrg.width()/3, 0), new Point(imgOrg.width(), imgOrg.height()/3));
		Rect rectBottomLeft = new Rect(new Point(0, 2*imgOrg.height()/3), new Point(imgOrg.width()/3, imgOrg.height()));
		Rect rectBottomRight = new Rect(new Point(2*imgOrg.width()/3, 2*imgOrg.height()/3), new Point(imgOrg.width(), imgOrg.height()));
		
		if (area == 0)
		{
			System.out.println("bad");
		}
		else if(bound.contains(new Point(imgOrg.width()/2, imgOrg.height()/2)) || rectCenter.contains(boundCntr)){
//		if(contours.contains(new Point(imgOrg.width()/2, imgOrg.height()/2))){

			System.out.println("Good/Center");
		}
		else if (rectLeft.contains(boundCntr))
		{
			System.out.println("left");
		}
		else if (rectRight.contains(boundCntr))
		{
			System.out.println("right");
		}
		else if (rectTop.contains(boundCntr))
		{
			System.out.println("top");
		}
		else if (rectBot.contains(boundCntr))
		{
			System.out.println("bot");
		}
		else if (rectTopLeft.contains(boundCntr))
		{
			System.out.println("top left");
		}
		else if (rectTopRight.contains(boundCntr))
		{
			System.out.println("top right");
		}
		else if (rectBottomLeft.contains(boundCntr))
		{
			System.out.println("bot left");
		}
		else if (rectBottomRight.contains(boundCntr))
		{
			System.out.println("bot right");
		}
		else
		{
			System.out.println("Bad");
		}
		
		//probably not needed, replaced by josh code
		if (bound.contains(new Point(imgOrg.width() / 2, imgOrg.height() / 2))) {
			// if(contours.contains(new Point(imgOrg.width()/2,
			// imgOrg.height()/2))){
			System.out.println("Good");

		} else {
			
			System.out.println("bad");
		}
		
		//andrew
		while (Ultra >= 12) {
			if (mid >= 330) {
				// Put motor strafe Right here
				System.out.println("Move Right");
			} else if (mid <= 310) {
				// motor strafe left here
				System.out.println("Move Left");
			} else if (mid >= 310 & mid <= 330) {
				// Motor forward here
				System.out.println("Centered; Move Forward");
			}
		}
		
		
		//NOT ANDREW

		//debug rectangles
		Core.rectangle(imgOrg, rectTopLeft.tl(), rectTopLeft.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectTop.tl(), rectTop.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectTopRight.tl(), rectTopRight.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectLeft.tl(), rectLeft.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectCenter.tl(), rectCenter.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectRight.tl(), rectRight.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectBottomLeft.tl(), rectBottomLeft.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectBot.tl(), rectBot.br(), new Scalar(0, 153, 255));
		Core.rectangle(imgOrg, rectBottomRight.tl(), rectBottomRight.br(), new Scalar(0, 153, 255));
		
		if (area != 0) Core.rectangle(imgOrg, new Point(boundCntr.x - 3,  boundCntr.y - 3), new Point(boundCntr.x + 3, boundCntr.y + 3), 
				new Scalar(255, 255, 204));
		
		Highgui.imwrite(filename, imgOrg);
	}

}
		

