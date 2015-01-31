import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;


public class Detector{
	
	private String filename;
	private Mat frame = new Mat();
	private String directory = "C:/Users/Eyob Woldeghebriel/Desktop/opencv/sources/data/haarcascades/";
	
	public Detector(String filename, Mat image){
		this.filename = filename;
		this.frame = image;
	}
	
	public void run(){
		
      CascadeClassifier faceDetector = new CascadeClassifier();
      CascadeClassifier eyes_cascade = new CascadeClassifier();
      if (!faceDetector.load(directory+"haarcascade_frontalface_alt.xml"))
      {
          System.out.print("--(!)Error loading\n");
          return;
      }
      if(!eyes_cascade.load(directory+"haarcascade_eye_tree_eyeglasses.xml")){
    	  System.out.print("eye error");
      }
      
      
      Mat image = Highgui.imread("camera.jpg");

      MatOfRect faceDetections = new MatOfRect();
      faceDetector.detectMultiScale(image, faceDetections);
      
//      MatOfRect eyeDetections = new MatOfRect();
//      eyes_cascade.detectMultiScale(image, eyeDetections);

      for (Rect rect : faceDetections.toArray()) {
          Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                  new Scalar(0, 255, 0));
      }
      
//      for (Rect rect : eyeDetections.toArray()) {
//          Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
//                  new Scalar(0, 255, 0));
//      }

      Highgui.imwrite(filename, image);
	}

}
