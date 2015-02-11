package org.usfirst.frc2421.Cerberus.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Cerberus.Robot;

/**
 *
 */
public class  LiftTote extends Command {

	boolean isFinished = false;
	
    public LiftTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.roboSystem);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean stop = Robot.roboSystem.limitTop.get();
    	double speed = 1;
    	
    	if(stop){
    		Robot.roboSystem.setToteLifter(0);
    		isFinished = true;
    	}
    	else{
    		Robot.roboSystem.setToteLifter(-speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	isFinished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	isFinished = false;
    }
}

