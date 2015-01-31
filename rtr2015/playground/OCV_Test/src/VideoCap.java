import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;        
import org.opencv.highgui.VideoCapture; 

import javax.imageio.ImageIO;
import javax.swing.*;
        
public class VideoCap {
	static JFrame jf = new JFrame();
	
    public static void main (String args[]) throws IOException{
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setTitle("OpenCV");
    	jf.setSize(640, 480);
    	jf.setVisible(true);
    	
    	JLabel jp = new JLabel("", JLabel.CENTER);
    	jf.getContentPane().add(jp);
    	
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	VideoCapture camera = new VideoCapture(0);
    	
    	if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		Mat frame = new Mat();
//    	    while(true){
    	    	if (camera.read(frame)){
//    	    		System.out.println("Frame Obtained");
//    	    		System.out.println("Captured Frame Width " + 
//    	    		frame.width() + " Height " + frame.height());
//    	    		camera.
    	    		Highgui.imwrite("camera.jpg", frame);
    	    		System.out.println("New Pic!");
    	    		ImageIcon pic = new ImageIcon(ImageIO.read(new File("C:/Users/Eyob Woldeghebriel/workspace/OCV_Test/camera.jpg")));
    	    		jp = new JLabel("", pic, JLabel.CENTER);
    	        	jf.getContentPane().add(jp);
    	        	jf.pack();
    	    		System.out.println("OK");
//    	    		break;
    	    	}
//    	    }	
    	}
    	camera.release();
    }
}   