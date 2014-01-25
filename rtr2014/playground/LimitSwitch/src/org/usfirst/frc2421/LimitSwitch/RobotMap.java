// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.LimitSwitch;
    
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
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
    public static CANJaguar subsystem1motor3;
    public static CANJaguar subsystem1motor2;
    public static DigitalInput subsystem1Lower;
    public static DigitalInput subsystem1Upper;
    public static CANJaguar subsystem1motor1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        try { 
            subsystem1motor3 = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            subsystem1motor2 = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        subsystem1Lower = new DigitalInput(1, 2);
	LiveWindow.addSensor("Subsystem 1", "Lower", subsystem1Lower);
        
        subsystem1Upper = new DigitalInput(1, 1);
	LiveWindow.addSensor("Subsystem 1", "Upper", subsystem1Upper);
        
        try { 
            subsystem1motor1 = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
