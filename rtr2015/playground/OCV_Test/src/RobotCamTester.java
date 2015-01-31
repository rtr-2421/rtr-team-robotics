import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;


public class RobotCamTester {
	public static void main(String[] args) throws MalformedURLException, IOException{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		VideoCapture cap = new VideoCapture("rtsp://10.24.21.11/axis-media/media.amp");
		VideoCapture cap = new VideoCapture("rtsp://10.24.21.11/axis-media/media.amp");
		
		BufferedImage i = ImageIO.read(new URL("http://10.24.21.11/jpg/1/image.jpg"));		
		byte[] data = ((DataBufferByte) i.getRaster().getDataBuffer()).getData();
		Mat frame = new Mat(i.getHeight(), i.getWidth(), CvType.CV_8UC3);
		frame.put(0, 0, data);
		
		Highgui.imwrite("camera.jpg", frame);
		
//		while(true){
//			if(cap.isOpened()){
//				System.out.println("Camera opened.");
//				if(cap.read(frame)){
//					System.out.println("Camera opened.");
//				}
//			}
//			else{
//				System.out.println("No camera.");
//			}
//		}
	}
}
