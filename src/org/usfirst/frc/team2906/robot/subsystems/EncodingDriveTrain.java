package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;
import org.usfirst.frc.team2906.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EncodingDriveTrain extends Subsystem {

	private final RobotDrive robotDrive = RobotMap.encodingDriveTrain;

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    	
    	}

    	public void arcadeDrive(double move, double rotate) {
    		robotDrive.arcadeDrive(move, rotate);
    	}

    	public void tankDrive(double left, double right) {
    		robotDrive.tankDrive(left, right);
    	}
    	
    	public double getLeftDistance() {
    		return RobotMap.encoderLeftDrive.getDistance();
    	}
    	
    	public double getRightDistance() {
    		return RobotMap.encoderRightDrive.getDistance();
    	}

    	public void driveWithJoysticks() {
    		robotDrive.arcadeDrive(Robot.oi.getJoystick1X(), Robot.oi.getJoystick1Y());
    	}
		
		public void ResetEncoders(){
			RobotMap.encoderLeftDrive.reset();
			RobotMap.encoderRightDrive.reset();
		}
		
		public void stop() {
			robotDrive.arcadeDrive(0.0, 0.0);
			robotDrive.tankDrive(0.0, 0.0);
		}
}

