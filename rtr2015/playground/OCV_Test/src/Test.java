import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;


public class Test implements Runnable{
	
	private String filename;
	JFrame f = new JFrame();
	VideoCapture cap = new VideoCapture("http://10.24.21.11/jpg/image.cgi");
	Mat frame;
//	CascadeClassifier faceDetector;
//	CascadeClassifier eye_cascade;
	Detector d = new Detector("output.png", frame);
	ColorDetector c = new ColorDetector("output.png");
	
	public Test(String filename){
		this.filename = filename;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public void run(){
//    	if(!cap.isOpened()){
//    		System.out.println("No cam");
//    	}
//    	else{
//    		if(cap.read(frame)){
//				Highgui.imwrite("camera.jpg", frame);
    			BufferedImage i = null;
				try {
					i = ImageIO.read(new URL("http://10.24.21.11/jpg/1/image.jpg"));
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
				byte[] data = ((DataBufferByte) i.getRaster().getDataBuffer()).getData();
				Mat frame = new Mat(i.getHeight(), i.getWidth(), CvType.CV_8UC3);
				frame.put(0, 0, data);
		
				Highgui.imwrite("camera.jpg", frame);
//    				d.run();
					c.run();
    				try {
    					f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(filename)))));
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    				f.pack();
    				f.setVisible(true);    			
//    		}    		
//    	}
    } 
    
    
//    public void detectAndDisplay(Mat frame)
//    {
//   	 	String face_cascade_name = "C:/Users/Eyob Woldeghebriel/Desktop/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml";
//        VideoCapture camera = new VideoCapture(0);
////        VideoCapture camera = new VideoCapture("http://10.24.21.11/mjpg/video.mjpg");
// 
//        CascadeClassifier faceDetector = new CascadeClassifier("C:/Users/Eyob Woldeghebriel/Desktop/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml");
//        Mat image = frame;
//
//        // Detect faces in the image.
//        // MatOfRect is a special container class for Rect.
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(image, faceDetections);
//
//        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
//
//        // Draw a bounding box around each face.
//        for (Rect rect : faceDetections.toArray()) {
//            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
//        }
//
//        // Save the visualized detection.
//        System.out.println(String.format("Writing %s", filename));
//        Highgui.imwrite(filename, image);
//   }

}