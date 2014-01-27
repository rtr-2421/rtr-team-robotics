// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2421.SampleJaguar;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2421.SampleJaguar.commands.*;
import org.usfirst.frc2421.SampleJaguar.subsystems.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    Command autonomousCommand;
    AnalogChannel encoder = RobotMap.motorTestencoder;
    int pulsePerRotation = 360; //encoder pulse per rotation
        
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static motorTest motorTest;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        
        //DIO Port of Encoder
       
//        int driveWheelRadius = 1;
//        int pulsePerRotation = 360; //encoder pulse per rotation
//        double gearRatio = 1/1; //ratio between wheel and encoder
//        double driveEncoderPulsePerRot = pulsePerRotation*gearRatio; //pulse per rotation * gear ratio
//        double driveEncoderDistPerTick = (Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
//        int driveEncoderMinRate = 10; 
//        int driveEncoderMinPeriod = 10;
//              
//        encoder.setDistancePerPulse(driveEncoderDistPerTick);
//        encoder.setMaxPeriod(driveEncoderMinPeriod);//min period before reported stopped
//        encoder.setMinRate(driveEncoderMinRate);//min rate before reported stopped
//        encoder.start();
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        motorTest = new motorTest();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
	
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousCommand();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
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
        System.out.print("Encoder value = " + (encoder.getAverageVoltage() * 72));
//        System.out.print(" Raw value = " + Robot.motorTest.readRaw());
//        System.out.print(" Rate value = " + Robot.motorTest.readRate());
//        System.out.print(" Drive value = " + Robot.motorTest.readDriven());
//        System.out.println("");
    }
    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
