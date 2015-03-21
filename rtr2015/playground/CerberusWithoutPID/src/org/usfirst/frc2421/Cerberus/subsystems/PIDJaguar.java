package org.usfirst.frc2421.Cerberus.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.PIDOutput;

public class PIDJaguar implements PIDOutput {

	private CANJaguar motor;

	public PIDJaguar(CANJaguar jag) {
		motor = jag;
	}

	public void pidWrite(double output) {
		double rate = motor.get() - output;
		if (rate > 1) {
			rate = 1;
		} else if (rate < -1) {
			rate = -1;
		}
		motor.set(rate);
	}
}
