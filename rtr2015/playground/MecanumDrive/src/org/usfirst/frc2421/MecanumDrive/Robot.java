// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2421.MecanumDrive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2421.MecanumDrive.commands.*;
import org.usfirst.frc2421.MecanumDrive.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drive drive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drive = new Drive();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousCommand();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        double a = 0;
        double b = 1;
        
        double step = OI.driveStick.getThrottle();
        
        double x = OI.driveStick.getX();
        double y = OI.driveStick.getY();
        double w = OI.turnStick.getX();
        
        double m1 = x + y - w*(a+b);
        double m2 = -x + y + w*(a+b);
        double m3 = -x + y - w*(a+b);
        double m4 = x + y + w*(a+b);
                
        if(m1 > 1){
        	m1 = 1;
        }
        if(m1 < -1){
        	m1 = -1;
        }
        
        if(m2 > 1){
        	m2 = 1;
        }
        if(m2 < -1){
        	m2 = -1;
        }
        
        if(m3 > 1){
        	m3 = 1;
        }
        if(m3 < -1){
        	m3 = -1;
        }
        
        if(m4 > 1){
        	m4 = 1;
        }
        if(m4 < -1){
        	m4 = -1;
        }
        
        drive.setMotor1(-m1);
        drive.setMotor2(m2);
        drive.setMotor3(-m3);
        drive.setMotor4(m4);
        
//        if(drive.motor1.get() > m1){
//        	double current = drive.motor1.get();
//        	drive.motor1.set(current-step);
//        }
//        else if(drive.motor1.get() < m1){
//        	double current = drive.motor1.get();
//        	drive.motor1.set(current+step);
//        }
//        
//        if(drive.motor2.get() > m2){
//        	double current = drive.motor2.get();
//        	drive.motor2.set(current-step);
//        }
//        else if(drive.motor2.get() < m2){
//        	double current = drive.motor2.get();
//        	drive.motor2.set(current+step);
//        }
//        
//        if(drive.motor3.get() > m3){
//        	double current = drive.motor3.get();
//        	drive.motor3.set(current-step);
//        }
//        else if(drive.motor3.get() < m3){
//        	double current = drive.motor3.get();
//        	drive.motor3.set(current+step);
//        }
//        
//        if(drive.motor4.get() > m4){
//        	double current = drive.motor4.get();
//        	drive.motor4.set(current-step);
//        }
//        else if(drive.motor4.get() < m4){
//        	double current = drive.motor4.get();
//        	drive.motor4.set(current+step);
//        }
        
        Timer.delay(0.01);        
        
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
