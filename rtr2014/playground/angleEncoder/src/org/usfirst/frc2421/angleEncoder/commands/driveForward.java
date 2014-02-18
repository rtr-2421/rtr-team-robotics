/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.angleEncoder.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.angleEncoder.Robot;
import org.usfirst.frc2421.angleEncoder.RobotMap;

/**
 *
 * @author Driver
 */
public class driveForward extends Command {
    
    double speed = Robot.bigRedButton.speed;
    
    public driveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            Robot.bigRedButton.setX(speed);
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
        try {
            Robot.bigRedButton.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        try {
            Robot.bigRedButton.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
