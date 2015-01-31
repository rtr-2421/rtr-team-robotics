package org.usfirst.frc2421.PIDTest;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.PIDOutput;

public class PIDJaguar implements PIDOutput{
	
	private CANJaguar jag;
	
	public PIDJaguar(CANJaguar motor){
		jag = motor;
	}
	
	public void pidWrite(double output){
		double rate = jag.get() + output;
		rate = Math.min(-1, rate);
		rate = Math.max(1, rate);
		jag.set(rate);
	}
	
}
