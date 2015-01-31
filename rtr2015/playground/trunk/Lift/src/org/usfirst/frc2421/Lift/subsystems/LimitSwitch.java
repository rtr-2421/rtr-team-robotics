package org.usfirst.frc2421.Lift.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.Lift.RobotMap;

/**
 *
 */
public class LimitSwitch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static boolean limitValueLS1(){
    	return RobotMap.LimitSwitch1.get(); 
    }
    public static boolean limitOutput1 = limitValueLS1();
    
    public static boolean limitValueLS2(){
    	return RobotMap.LimitSwitch2.get(); 
    }
    public static boolean limitOutput2 = limitValueLS2();
}

