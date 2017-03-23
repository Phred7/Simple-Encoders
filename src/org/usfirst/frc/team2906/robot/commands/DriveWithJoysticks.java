package org.usfirst.frc.team2906.robot.commands;



import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {

    	requires(Robot.encodingDriveTrain);

    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.encodingDriveTrain.driveWithJoysticks();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
