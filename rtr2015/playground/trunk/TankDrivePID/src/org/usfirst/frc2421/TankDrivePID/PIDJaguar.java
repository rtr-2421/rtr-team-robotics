package org.usfirst.frc2421.TankDrivePID;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.PIDOutput;

public class PIDJaguar implements PIDOutput{

	private CANJaguar motor;
	
	public PIDJaguar(CANJaguar jag){
		motor = jag;
	}
	
	public void pidWrite(double output){
		double speed = motor.get() - output;
		Math.max(speed, -1);
		Math.min(speed, 1);
		motor.set(speed);
	}
	
}
