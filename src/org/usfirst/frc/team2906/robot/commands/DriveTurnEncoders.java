package org.usfirst.frc.team2906.robot.commands;



import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnEncoders extends Command {
	int left;
	int right;
	int leftRight;
	int ftDistance;
	int inDistance;
	int driveDistance;
	double endDistanceLeft;
	double endDistanceRight;
	double botSpeed;
	double leftSpeed;
	double rightSpeed;
	double leftRightChange;
	double leftEncodingValue;
	double rightEncodingValue;


    public DriveTurnEncoders(double speed, int userFeet, int userInches, int direction) {

    	requires(Robot.encodingDriveTrain);
    	
    	driveDistance = (userInches + (12 * userFeet));
    	botSpeed = speed;
    	leftSpeed = leftRightChange;
    	rightSpeed = leftRightChange;
    	leftEncodingValue = Robot.leftEncodingValue;
    	rightEncodingValue = Robot.rightEncodingValue;
    	leftRight = direction;
    	left = 10;
    	right = 110;
    	//rightEncodingValue = Math.abs(Robot.encodingDriveTrain.getRightDistance());
    }

    protected void initialize() {

    	if(leftRight == left){
    		leftRightChange = botSpeed*-1;
    		driveDistance = driveDistance*-1;
    	}
    	else if(leftRight == right){
    		leftRightChange = botSpeed*1;
    	}
    	
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