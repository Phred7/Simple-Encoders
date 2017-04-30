package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurnLeftSide extends Command {
	int left;
	int right;
	int leftRight;
	int ftDistance;
	int inDistance;
	int tDirection;
	int driveDistance;
	double endDistance;
	double botSpeed;
	double leftSpeed;
	double rightSpeed;
	double speedChange;
	double leftEncodingValue;
	
	
    public DriveTurnLeftSide(double speed, int userFeet, int userInches, int direction) {
requires(Robot.encodingDriveTrain);
    	
    	driveDistance = (userInches + (12 * userFeet));
    	botSpeed = speed;
    	leftSpeed = speedChange;
    	rightSpeed = speedChange;
    	leftEncodingValue = Robot.leftEncodingValue;
    	tDirection = direction;
    	left = 10;
    	right = 110;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(tDirection == left){
    		speedChange = botSpeed*-1;
    		driveDistance = driveDistance*-1;
    	}
    	else if(tDirection == right){
    		speedChange = botSpeed*1;
    	}
    	
    	endDistance = leftEncodingValue + driveDistance;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.encodingDriveTrain.tankDrive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (leftEncodingValue >= endDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.encodingDriveTrain.stopLeft(rightSpeed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
