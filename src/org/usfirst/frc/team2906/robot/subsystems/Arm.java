package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	private final SpeedController Arm = RobotMap.armControl;

	public void hold(){
		
	}
	
	public void armUp(){
		Arm.set(1.0);	
	}
	
	public void armDown(){
		Arm.set(0.2);
	}
	
	public void armUpSlow(){
		Arm.set(0.6);
	}
	
	public void armDownSlow(){
		Arm.set(0.25);
	}
	
	public void errorUp(){
		
	}
	
	public void errorDown(){
		
	}
	
	public void resetEncoder(){
		RobotMap.encoderArm.reset();
	}
	
	public double getEncoderDegree(){
		return RobotMap.encoderArm.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

