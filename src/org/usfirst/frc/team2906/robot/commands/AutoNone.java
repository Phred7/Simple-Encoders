package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoNone extends CommandGroup {

    public AutoNone() {
    	//int left = 10;
    	int right = 110;
        
    	addSequential(new DriveStop());
    	//addSequential(new DriveTurnEncoders(.5, 0, 12, left));
    	//fire any pistons to default positions and release any servos that are necessary
    }
}
