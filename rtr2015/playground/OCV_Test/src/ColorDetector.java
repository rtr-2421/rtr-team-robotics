import java.util.ArrayList;
import java.util.List;

import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.*;

import edu.wpi.first.wpilibj.networktables.NetworkTable;


public class ColorDetector implements Runnable{
	
	private String filename;
	private Scalar low = new Scalar(20, 100, 100);
	private Scalar high = new Scalar(40, 255, 255);
		
	public ColorDetector(String filename){
		this.filename = filename;
	}
	
	public void run(){
		
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
		Imgproc.findContours(imgThresholded, contours, new Mat(), Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
		
		for(int b = 0; b < contours.size(); b++){
			double a = Imgproc.contourArea(contours.get(b), false);
			if(a > area){
				area = a;
				bound = Imgproc.boundingRect(contours.get(b));
			}
		}
		
		Imgproc.cvtColor(imgThresholded, imgThresholded, Imgproc.COLOR_BayerBG2RGB);
		
		Imgproc.drawContours(imgOrg, contours, -1, new Scalar(0, 255, 0), 3);
		
		Core.rectangle(imgOrg, new Point(bound.x, bound.y), new Point(bound.x + bound.width, bound.y + bound.height), new Scalar(0, 255, 0));

		if(bound.contains(new Point(imgOrg.width()/2, imgOrg.height()/2))){
//		if(contours.contains(new Point(imgOrg.width()/2, imgOrg.height()/2))){
			System.out.println("Good");
		}
		else{
			System.out.println("Bad");
		}
		
		Highgui.imwrite(filename, imgOrg);
	}

}
