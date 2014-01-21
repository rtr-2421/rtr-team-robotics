// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.SampleJaguar.subsystems;
import org.usfirst.frc2421.SampleJaguar.RobotMap;
import org.usfirst.frc2421.SampleJaguar.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class motorTest extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANJaguar jagTest3 = RobotMap.motorTestjagTest3;
    CANJaguar jagTest1 = RobotMap.motorTestjagTest1;
    CANJaguar jagTest2 = RobotMap.motorTestjagTest2;
    Ultrasonic ultRange = RobotMap.motorTestultRange;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Sets the speed of all of the numbers to the provided input "speed"
    public void setX(double speed) throws CANTimeoutException {
        jagTest1.setX(speed);
        jagTest2.setX(speed);
        jagTest3.setX(speed);
    }
    
    //Gets the encoder value
    public double readEncoder(){
        return analogChannel.getAverageVoltage() * 72;
    }
    
    //main static variable
    double motorSpeed;
    
    //sets motor speed according to encoder value
    public void resetArm() {
        //check encoder, and sets the cjag motors to the start pos
        if(readEncoder() == 90) {
            motorSpeed = -.5;
            try {
                setX(motorSpeed);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
        }
        if(readEncoder() == 0) {
            motorSpeed = 0;
            try {
                setX(motorSpeed);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //I KNOW THERE ARE ERRORS!!!
    
    public void launchArm() {
        if(readEncoder() <= 0){
            motorSpeed = 1;
            try {
                setX(motorSpeed);
            } catch (CANTimeoutException ex){
                ex.printStackTrace();
            }
        }
      }
            
}
