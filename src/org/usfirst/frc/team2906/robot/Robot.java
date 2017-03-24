
package org.usfirst.frc.team2906.robot;

import org.usfirst.frc.team2906.robot.commands.AutoNone;
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



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.C:\Users\wward\Desktop\FRC Workspace\SentinelSteamworks
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	Command AutoNone;
	
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
	//final String autonomousCommand = "Auto Command I";
	
	String[] autoChooserList = { autoNone };

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
	    System.out.println("Auto selected: " + autoChooser.getSelected());
	   

		Robot.encodingDriveTrain.ResetEncoders();

		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	public void autonomousPeriodic() {
		
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value left", (RobotMap.encoderLeftDrive.get()));
        SmartDashboard.putNumber("encoder value right",  (RobotMap.encoderRightDrive.get()));
		
	}

	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("encoder value left", (RobotMap.encoderLeftDrive.get()));
        SmartDashboard.putNumber("encoder value right",  (RobotMap.encoderRightDrive.get()));
	}

	public void testPeriodic() {
		LiveWindow.run();
	}

}
