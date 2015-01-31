
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;
 
public class FaceDetect {
 
    public static void main(String[] args) {
 
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        String face_cascade_name = "C:/Users/Eyob Woldeghebriel/Desktop/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml";
        VideoCapture camera = new VideoCapture(0);
//        VideoCapture camera = new VideoCapture("http://10.24.21.11/mjpg/video.mjpg");
        Mat frame = new Mat();
 
        CascadeClassifier faceDetector = new CascadeClassifier();
        if (!faceDetector.load(face_cascade_name))
        {
            System.out.print("--(!)Error loading\n");
            return;
        }
        
        if (camera.read(frame)){
    		Highgui.imwrite("camera.jpg", frame);
    		System.out.println("New Pic!");
    	}
        
        Mat image = Highgui.imread("camera.jpg");
 
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
 
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
 
        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }
 
        String filename = "ouput.png";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);
        
    }
}
