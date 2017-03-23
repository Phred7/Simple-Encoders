package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoNone extends CommandGroup {

    public AutoNone() {
        
    	addSequential(new DriveStop());
    }
}
