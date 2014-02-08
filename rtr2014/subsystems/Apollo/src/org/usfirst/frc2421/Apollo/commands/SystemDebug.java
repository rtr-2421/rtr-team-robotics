/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Apollo.commands;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Apollo.RobotMap;

/**
 *
 * @author Driver
 */
public class SystemDebug extends Command {
    
    Encoder catAngle = RobotMap.catAngle;
    Encoder leftDrive = RobotMap.leftWheelEncoder;
    Encoder rightDrive = RobotMap.rightWheelEncoder;
    AnalogChannel ultraRange = RobotMap.ultrasonicRangeFinder;

    public synchronized void cancel() {
        super.cancel(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public SystemDebug() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        System.out.println(
            "Catapult raw value: " + getCatapult(catAngle)+ "/n"+
            "Right drive raw value: " + getDrive(rightDrive)+"/n"+
            "Left drive raw value: " + getDrive(leftDrive)+"/n"+
            "Ultrasonic range: " + findRange(ultraRange)
        );
        
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
    
    public double getCatapult(Encoder catapultEncoder){        
        return catAngle.getRaw();       
    }
    
     public double getDrive(Encoder driveEncoder){        
        return driveEncoder.getRaw();       
    }
    
    public double findRange(AnalogChannel rangeFinder){
        return rangeFinder.getAverageVoltage() * 8.8573;
    }

    
}
