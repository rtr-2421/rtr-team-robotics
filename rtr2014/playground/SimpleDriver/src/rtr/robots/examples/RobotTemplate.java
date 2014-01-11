/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Testing -Josh
package rtr.robots.examples;


import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

    CANJaguar driveLeft;
    CANJaguar driveRight;
    Joystick leftStick;
    Joystick rightStick;
    RobotDrive driveSystem;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called prior to teleop
     */
    public void teleopInit() {
        try {
            driveLeft = new CANJaguar(1);
            driveRight = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            System.err.println("CAN Timeout error.");
        }
        /* two joystick tankdrive */
        driveSystem = new RobotDrive(driveLeft, driveRight);
        leftStick = new Joystick(1);
        rightStick = new Joystick(2);
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        driveSystem.tankDrive(leftStick, rightStick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
//test comment change