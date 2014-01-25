// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.SampleJaguar;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANJaguar motorTestjagTest3;
    public static CANJaguar motorTestjagTest1;
    public static CANJaguar motorTestjagTest2;
    public static Ultrasonic motorTestultRange;
    public static Encoder motorTestencoder;
    public static CANJaguar motorTestdriveCan1;
    public static CANJaguar motorTestdriveCan2;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
//        try { 
//            motorTestjagTest3 = new CANJaguar(5);
//        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
//        }
	
        
        try { 
            motorTestjagTest1 = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            motorTestjagTest2 = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        //motorTestultRange = new Ultrasonic(1, 1, 1, 2);
	//LiveWindow.addSensor("motorTest", "ultRange", motorTestultRange);
        
        motorTestencoder = new Encoder(2, 1);
	LiveWindow.addSensor("motorTest", "encoder", motorTestencoder);
        
//        try { 
//            motorTestdriveCan1 = new CANJaguar(5);
//        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
//        }
	
        
//        try { 
//            motorTestdriveCan2 = new CANJaguar(6);
//        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
//        }
	
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
