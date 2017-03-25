package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTesting extends CommandGroup {

    public AutoTesting() {
    	int left = 10;
    	int right = 110;
        
    	addSequential(new DriveTurnEncoders(.5, 0, 12, left));
    }
}
