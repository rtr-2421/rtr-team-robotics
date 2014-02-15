/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Apollo.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Apollo.Robot;
import org.usfirst.frc2421.Apollo.RobotMap;

/**
 *
 * @author Driver
 */
public class FireCat extends Command {
    
    static int initialValue;//Initial value of encoder
    double motorspeed = Robot.catapult.fireSpeed;//Speed of catapult motor
    Encoder catAngle = RobotMap.catAngle;//The catapult's encoder
    int value;
    boolean finished;
    
    public FireCat() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialValue = catAngle.getRaw();//Setting the initial value.
        finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        value = initialValue - catAngle.getRaw();
        value /= 2;
        
        if(value < 0){
            value *= -1;
        }
        
        if(value < 195){
        try {
            Robot.catapult.setX(motorspeed);//Setting the motorspeed
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        }
        
        if(value >= 195){
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
            Robot.catapult.setX(0);//Stopping motor when finished
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        try {
            Robot.catapult.setX(0);//Stopping motor when interrupted
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
