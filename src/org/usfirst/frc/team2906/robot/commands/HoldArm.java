package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HoldArm extends Command {

	double speedVariantUp;
	double speedVariantDown;
	double endDegree;
	double changeDegree;
	
    public HoldArm(double userDegrees, double up, double down ) {
        
    	requires(Robot.armControl);
    	changeDegree = userDegrees;
    	speedVariantUp = up;
    	speedVariantDown = down;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.armControl.resetEncoder();
    	
    	endDegree = changeDegree + RobotMap.encoderArm.getDistance();
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(RobotMap.encoderArm.getDistance() >= endDegree){
    		Robot.armControl.armUpSlow();
    	}
    	
    	
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (RobotMap.encoderArm.getDistance() >= endDegree);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
