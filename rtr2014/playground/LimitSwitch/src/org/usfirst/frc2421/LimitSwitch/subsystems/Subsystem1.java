// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.LimitSwitch.subsystems;
import org.usfirst.frc2421.LimitSwitch.RobotMap;
import org.usfirst.frc2421.LimitSwitch.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Subsystem1 extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //CANJaguar motor3 = RobotMap.subsystem1motor3;
    CANJaguar motor2 = RobotMap.subsystem1motor2;
    DigitalInput lower = RobotMap.subsystem1Lower;
    DigitalInput upper = RobotMap.subsystem1Upper;
    CANJaguar motor1 = RobotMap.subsystem1motor1;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void turnMotorsOn(double motorSpeed) throws CANTimeoutException{
        motor1.setX(motorSpeed);
        motor2.setX(motorSpeed);
        //motor3.setX(motorSpeed);
    }
    public boolean lowerLimit(){
        return lower.get();
        
    }
    public boolean upperLimit(){
        return upper.get();
    
    }
}
