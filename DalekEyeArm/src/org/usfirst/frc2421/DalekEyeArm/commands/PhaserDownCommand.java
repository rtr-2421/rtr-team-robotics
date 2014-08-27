// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.DalekEyeArm.commands;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.DalekEyeArm.Robot;
/**
 *
 */
public class  PhaserDownCommand extends Command {
   boolean finished = true;
    public PhaserDownCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
	requires(Robot.armPhaser);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        try{
        Robot.armPhaser.setPhaserX(.25);
        } catch (CANTimeoutException ex) {   
          finished = true;
        }
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
                if (Robot.oi.getphaserLimitDown()) {
            try{
                Robot.armPhaser.setPhaserX(0);
            } catch(CANTimeoutException ex){
            }
            finished = true;
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }
    // Called once after isFinished returns true
    protected void end() {
             try{
                Robot.armPhaser.setPhaserX(0);
            } catch(CANTimeoutException ex){
            }   
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        try{
                Robot.armPhaser.setPhaserX(0);
            } catch(CANTimeoutException ex){
            }   
    }
}
