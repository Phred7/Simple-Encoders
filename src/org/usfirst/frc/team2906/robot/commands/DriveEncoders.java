package org.usfirst.frc.team2906.robot.commands;



import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveEncoders extends Command {
	int ftDistance;
	int inDistance;
	int driveDistance;
	double endDistanceLeft;
	double endDistanceRight;
	double botSpeed;
	double leftSpeed;
	double rightSpeed;
	double leftEncodingValue;
	double rightEncodingValue;


    public DriveEncoders(double speed, int userFeet, int userInches) {

requires(Robot.encodingDriveTrain);
    	
    	driveDistance = (userInches + (12 * userFeet));
    	botSpeed = speed;
    	leftSpeed = botSpeed;
    	rightSpeed = botSpeed;
    	leftEncodingValue = Robot.leftEncodingValue;
    	rightEncodingValue = Robot.rightEncodingValue;
    	//rightEncodingValue = Math.abs(Robot.encodingDriveTrain.getRightDistance());
    }

    protected void initialize() {
    	endDistanceRight = rightEncodingValue + driveDistance;
    	endDistanceLeft = leftEncodingValue + driveDistance;
    }

    protected void execute() {
    	Robot.encodingDriveTrain.tankDrive(leftSpeed, rightSpeed);
    }

    protected boolean isFinished() {
        return (rightEncodingValue >= endDistanceRight && leftEncodingValue >= endDistanceLeft);
    }

    protected void end() {
    	Robot.encodingDriveTrain.stop();
    }

    protected void interrupted() {
    }
}