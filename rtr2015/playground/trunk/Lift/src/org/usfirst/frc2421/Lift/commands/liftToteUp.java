package org.usfirst.frc2421.Lift.commands;

import org.usfirst.frc2421.Lift.OI;
import org.usfirst.frc2421.Lift.RobotMap;
import org.usfirst.frc2421.Lift.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class liftToteUp extends Command {
	boolean isFinished = false;
	
    public liftToteUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isFinished = true;
    	boolean LimitOutputBoolean = true;
    	//boolean LimitOutputBoolean = LimitSwitch.limitOutput1;
    	double speed = 1;    	
    	
    	RobotMap.liftmotorCANJaguarLiftTote.set(-speed);//Go up
    	if(LimitOutputBoolean == false)
    	{
    		RobotMap.liftmotorCANJaguarLiftTote.set(0);
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
