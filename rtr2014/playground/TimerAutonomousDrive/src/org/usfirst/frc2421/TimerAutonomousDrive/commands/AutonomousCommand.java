// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2421.TimerAutonomousDrive.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.TimerAutonomousDrive.Robot;

/**
 *
 */
public class  AutonomousCommand extends Command {
int driveTime = 4;//measured in seconds
    int loopTimer = driveTime * 80;//80 is the time per second
    boolean timerIsFinished = false;
    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (loopTimer >= 0){
        try {
            Robot.drive.setMotorValues(1);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        loopTimer = loopTimer - 1;   
    
        }
        else {
            timerIsFinished = true;
        }
        System.out.println(loopTimer);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timerIsFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    try {
        Robot.drive.setMotorValues(0);
    } catch (CANTimeoutException ex) {
        ex.printStackTrace();
    }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
