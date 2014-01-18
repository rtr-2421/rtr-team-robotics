// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2421.TankDriveTrainingProgram;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc2421.TankDriveTrainingProgram.commands.*;
import org.usfirst.frc2421.TankDriveTrainingProgram.subsystems.*;
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
        
        Joystick driveControl;
        driveControl = new Joystick(1);//Creating the joystick.
        
        double x;
        x = driveControl.getX();//x and y where switched on joystick, so it's fixed in the code.
        double y;
        y = driveControl.getY();//Same as above.
        
        double maxMotor;
        double leftSpeed = 0;
        double rightSpeed = 0;
        final double deadZone = 0.2;
        
        if((-deadZone < x) && (x < deadZone) && (-deadZone < y) && (y < deadZone)){//Checking if the joystick is in the deadzone.
            leftSpeed = 0;//Shouldn't move while inside deadzone.
            rightSpeed = 0;//Same as above.
        }
        else{ 
            leftSpeed = y + x;//y is speed, and x is turn. We found out that the left motor's value should be speed + turn.
            rightSpeed = y - x;//Same as above, but the right motor's value should be speed - turn.
        }
                
        if(Math.abs(y) > Math.abs(x)){
            maxMotor = Math.abs(y);//Necessary to divide by highest absolute motor value when input is larger than one,
                         //so we check to see which motor has the highest absolute value.
        }
        else{
            maxMotor = Math.abs(x);//See above.
        }
        
        leftSpeed /= maxMotor;//Dividing by the highest motor absolute value, found above. 
        rightSpeed /= maxMotor;//Same.
        
        //Limiting the values to be between 1 and -1 which is what the motors accept.
        if(leftSpeed > 1){
            leftSpeed = 1;
        }
        else if(leftSpeed < -1){
            leftSpeed = -1;
        }
        
        if(rightSpeed > 1){
            rightSpeed = 1;
        }
        else if(rightSpeed < -1){
            rightSpeed = -1;
        }
        try {
            drive.controlMotorL(leftSpeed);//Setting the left motor speed.
            drive.controlMotorR(-rightSpeed);//Setting the right motor speed.
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        
    }
    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
