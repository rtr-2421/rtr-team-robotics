import org.opencv.core.*;
import org.opencv.highgui.VideoCapture;
 
public class FaceDetector{
	
	private static String window_name = "Capture - Face detection";
	
   /**
    * @param args
    */
    public static void main(String args[])
    {
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  	  VideoCapture capture;
  	  
      //-- 2. Read the video stream
      capture = new VideoCapture("http://10.24.21.11/jpg/1/image.jpg");
      
	  Test te = new Test("output.png");
	  Thread t = new Thread(te);
	  t.setDaemon(true);
	  
      while(true){
    	  t.run();
      }
    }
}
