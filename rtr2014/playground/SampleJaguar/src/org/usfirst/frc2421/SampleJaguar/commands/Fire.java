// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.SampleJaguar.commands;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.SampleJaguar.Robot;
import org.usfirst.frc2421.SampleJaguar.RobotMap;
/**
 *
 */
public class  Fire extends Command {
    public double motorSpeed;
    Reset reset = new Reset();
    boolean finished = false;
    public static final double DEADZONE = 131.18;
    static int initialValue;
    
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    
    // Called just before this Command runs the first time
    protected void initialize() {
        initialValue = RobotMap.motorTestencoder.getRaw();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        int value = initialValue - RobotMap.motorTestencoder.getRaw();
        value /= 2;        
        
        if(reset.isActive()){
            motorSpeed = 0;
            finished = true;
        }
        if(value < (0 + DEADZONE)) /*&& (Robot.motorTest.readEncoder() < 90 + DEADZONE)*/{
            motorSpeed = 0.25;
            try {
                Robot.motorTest.setX(motorSpeed);
            } catch (CANTimeoutException ex){
                ex.printStackTrace();
            }
        }
        else if(value >= (90 + DEADZONE)) {
            motorSpeed = 0;
            finished = true;
            System.out.println("Stop");
            try {
                Robot.motorTest.setX(motorSpeed);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }
    // Called once after isFinished returns true
    protected void end() {
        finished = false;
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        finished = true;
    }
    
    protected boolean isActive(){
        boolean isFinished = !finished;
        return isFinished;
    }
    
}
