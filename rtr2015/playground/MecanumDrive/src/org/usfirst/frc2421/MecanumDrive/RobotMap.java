// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2421.MecanumDrive;
    
import edu.wpi.first.wpilibj.CANJaguar;
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
    public static CANJaguar drivemotor1;
    public static CANJaguar drivemotor2;
    public static CANJaguar drivemotor3;
    public static CANJaguar drivemotor4;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivemotor1 = new CANJaguar(17);
        
        
        drivemotor2 = new CANJaguar(3);
        
        
        drivemotor3 = new CANJaguar(6);
        
        
        drivemotor4 = new CANJaguar(7);
        
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
