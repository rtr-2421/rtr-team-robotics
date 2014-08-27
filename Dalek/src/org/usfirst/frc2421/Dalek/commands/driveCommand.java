// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2421.Dalek.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Dalek.Robot;

/**
 *
 */
public class  driveCommand extends Command {

    public driveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double x = Robot.oi.joystick.getX();
        double y = Robot.oi.joystick.getY();
        
        double driveSpeed;
        double turnSpeed;
        
        double deadZone = 0.2;
        
        if((x < deadZone) && (x > -deadZone) && (y < deadZone) && (y > -deadZone)){
            driveSpeed = 0;
            turnSpeed = 0;
        }
        else{
            driveSpeed = y;
            turnSpeed = x;
        }
        
        if(y > 1){
            y = 1;
        }
        else if(y < -1){
            y = -1;
        }
        
        if(x > 1){
            x = 1;
        }
        else if(x < -1){
            x = -1;
        }
        
        try {
            Robot.drive.setLeftSpeed(driveSpeed);
            Robot.drive.setRightSpeed(turnSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
