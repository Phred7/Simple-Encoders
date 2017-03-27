
package org.usfirst.frc.team2906.robot;

import org.usfirst.frc.team2906.robot.commands.*;
import org.usfirst.frc.team2906.robot.subsystems.Arm;
import org.usfirst.frc.team2906.robot.subsystems.EncodingDriveTrain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	Command autonomousCommand;
	Command AutoNone;
	Command AutoTesting;
	
	public static OI oi;
	public static Arm armControl;
	public static Encoder encoderLeftDrive;
	public static Encoder encoderRightDrive;
	public static CameraServer cameraserver;
	public static EncodingDriveTrain encodingDriveTrain;
	
	public static double leftEncodingValue = Math.abs(Robot.encodingDriveTrain.getLeftDistance());
	public static double rightEncodingValue = Math.abs(Robot.encodingDriveTrain.getRightDistance());

	
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	final String autoNone = "No Auto";
    final String autoTesting = "Test Auto";
	
	String[] autoChooserList = { autoNone, autoTesting };

	@Override
	public void robotInit() {
		RobotMap.init();
		
		oi = new OI();
		
		encodingDriveTrain = new EncodingDriveTrain();
		armControl = new Arm(); 
		
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putStringArray("Auto List", autoChooserList);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("No Auto", new AutoNone());
		autoChooser.addObject("Test Auto", new AutoTesting());
		
		
		SmartDashboard.putData("Auto mode", autoChooser);
	}

	public void disabledInit() {
		Robot.encodingDriveTrain.ResetEncoders();
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomousCommand = (Command) autoChooser.getSelected();
		SmartDashboard.getData("Auto selected: " + autoChooser.getSelected());
	    //System.out.println("Auto selected: " + autoChooser.getSelected());
	   

		Robot.encodingDriveTrain.ResetEncoders();

		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value left", (RobotMap.encoderLeftDrive.get()));
        SmartDashboard.putNumber("encoder value right",  (RobotMap.encoderRightDrive.get()));
        SmartDashboard.putNumber("Arm Encoder", (RobotMap.encoderArm.get()));
		
	}

	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value left", (RobotMap.encoderLeftDrive.get()));
        SmartDashboard.putNumber("encoder value right",  (RobotMap.encoderRightDrive.get()));
        SmartDashboard.putNumber("Arm Encoder", (RobotMap.encoderArm.get()));
        SmartDashboard.putNumber("Arm Degree", (RobotMap.encoderArm.getDistance()));
	}

	public void testPeriodic() {
		LiveWindow.run();
	}

}
