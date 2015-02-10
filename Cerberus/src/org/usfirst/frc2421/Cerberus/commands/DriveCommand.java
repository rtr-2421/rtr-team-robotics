package org.usfirst.frc2421.Cerberus.commands;


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2421.Cerberus.Robot;

/**
 *
 */
public class  DriveCommand extends Command {

    public DriveCommand() {
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
    	 double x = Robot.oi.driveStick.getX();
         double y = Robot.oi.driveStick.getY();
         double w = Robot.oi.turnStick.getX();
         
         double a = 0;
         double b = 1;
         
         double m1 = x + y - w*(a+b);
         double m2 = -x + y + w*(a+b);
         double m3 = -x + y - w*(a+b);
         double m4 = x + y + w*(a+b);
         
         Math.max(m1, -1);
 		 Math.min(m1, 1);
 		
 		 Math.max(m2, -1);
 		 Math.min(m2, 1);
 		
 		 Math.max(m3, -1);
 		 Math.min(m3, 1);
 		
 		 Math.max(m4, -1);
 		 Math.min(m4, 1);
         
         Robot.roboSystem.setSpeedFrontLeftMotor(-m1);
         Robot.roboSystem.setSpeedFrontRightMotor(m2);
         Robot.roboSystem.setSpeedBackLeftMotor(-m3);
         Robot.roboSystem.setSpeedBackRightMotor(m4);
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

