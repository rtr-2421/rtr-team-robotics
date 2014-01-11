// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2421.TankDriveTrainingProgram.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import org.usfirst.frc2421.TankDriveTrainingProgram.RobotMap;
import org.usfirst.frc2421.TankDriveTrainingProgram.commands.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Drive extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANJaguar leftWheel = RobotMap.driveleftWheel;
    CANJaguar rightWheel = RobotMap.driverightWheel;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void controlMotorL(double lMotorPower) throws CANTimeoutException{ 
        leftWheel.setX(lMotorPower);
    }
    
    //Sets the speed of the right motor.
    public void controlMotorR(double rMotorPower) throws CANTimeoutException{
        rightWheel.setX(rMotorPower);
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
