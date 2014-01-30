// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2421.LimitSwitch.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.LimitSwitch.Robot;


/**
 *
 */
public class  ReleaseCatapult extends Command {
final int motorPower = 1;
boolean finished = false;
    private Subsystem Subsystem;
    public ReleaseCatapult() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	requires(Subsystem);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         if (Robot.subsystem1.upperLimit()){
        finished = false;
         }
         else{
          try {
           
            Robot.subsystem1.turnMotorsOn(-motorPower);
        } catch (CANTimeoutException ex) {
        }
         
         }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.subsystem1.lowerLimit() == false){
           finished = true; 
    }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    try {
        Robot.subsystem1.turnMotorsOn(0);
    } catch (CANTimeoutException ex) {
    }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
