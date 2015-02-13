package org.usfirst.frc2421.PIDTest.commands;

import org.usfirst.frc2421.PIDTest.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDValueDecrease extends Command {
	
	boolean isFinished = false;

    public PIDValueDecrease() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drive.Kp -= 0.001; // Change to whichever (p,i,d) that you want.
    	System.out.println(Drive.Kp);
    	isFinished = true;
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
