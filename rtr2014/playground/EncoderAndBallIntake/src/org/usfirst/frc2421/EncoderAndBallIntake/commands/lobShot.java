/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.EncoderAndBallIntake.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.EncoderAndBallIntake.Robot;
import org.usfirst.frc2421.EncoderAndBallIntake.RobotMap;
import org.usfirst.frc2421.EncoderAndBallIntake.subsystems.Catapult;

/**
 *
 * @author Eyob
 */
public class lobShot extends Command{
    
    public double motorspeed = Robot.catapult.motorspeed;
    public int lobAngle = Robot.catapult.lobAngle;
    boolean finished = false;
    static int initialValue;
    
    
    public lobShot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialValue = RobotMap.catapultEncoder.getRaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        int value = initialValue - RobotMap.catapultEncoder.getRaw();
        value /= 2;
        
        if(value < 0){
            value *= -1;
        }
        
        if(value < lobAngle){
        try {
            Robot.catapult.setX(motorspeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        }
        if(value >= lobAngle){
            try {
                Robot.catapult.setX(0);
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
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
        try {
            Robot.catapult.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        finished = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        try {
            Robot.catapult.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        finished = false;
    }
}
