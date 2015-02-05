// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.TankDrivePID;
    
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.Encoder;
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
    public static CANJaguar drivejag1;
    public static CANJaguar drivejag2;
    public static CANJaguar drivejag3;
    public static CANJaguar drivejag4;
    public static Encoder driveenc1;
    public static Encoder driveenc2;
    public static Encoder driveenc3;
    public static Encoder driveenc4;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivejag1 = new CANJaguar(2);
        
        
        drivejag2 = new CANJaguar(3);
        
        
        drivejag3 = new CANJaguar(4);
        
        
        drivejag4 = new CANJaguar(5);
        
        
        driveenc1 = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "enc1", driveenc1);
        driveenc1.setDistancePerPulse(1.0);
        driveenc1.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveenc2 = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "enc2", driveenc2);
        driveenc2.setDistancePerPulse(1.0);
        driveenc2.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveenc3 = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "enc3", driveenc3);
        driveenc3.setDistancePerPulse(1.0);
        driveenc3.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        driveenc4 = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "enc4", driveenc4);
        driveenc4.setDistancePerPulse(1.0);
        driveenc4.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
