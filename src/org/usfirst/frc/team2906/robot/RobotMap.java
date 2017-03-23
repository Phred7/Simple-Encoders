package org.usfirst.frc.team2906.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMap {

	public static SpeedController driveTrainLeft;
	public static SpeedController driveTrainRight;
	public static SpeedController armControl;
	public static Encoder encoderLeftDrive;
	public static Encoder encoderRightDrive;
	public static Encoder encoderArm;
	public static RobotDrive encodingDriveTrain;
	public static CameraServer driveCamI;

	public static double tickPerInch = 13.79;
	// for 6in wheels and AM toughbox mini. May need to be adjusted

	public static final double sensitivity = 0.1;


	public static void init() {

		driveTrainLeft = new Spark(0);
		driveTrainRight = new Spark(1);
		armControl = new Spark(2);

		encodingDriveTrain = new RobotDrive(driveTrainLeft, driveTrainRight);
		encodingDriveTrain.setSafetyEnabled(true);
		encodingDriveTrain.setExpiration(0.1);
		encodingDriveTrain.setSensitivity(0.1);
		encodingDriveTrain.setMaxOutput(1.0);
		encodingDriveTrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);

		encoderLeftDrive = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderLeftDrive.setPIDSourceType(PIDSourceType.kDisplacement);
		encoderLeftDrive.setDistancePerPulse(1.0 / tickPerInch);
		encoderLeftDrive.reset();

		// if the values in this string: encoderRightDrive = new Encoder(2, 3,
		// true, Encoder.EncodingType.k4X); overlap on either encoder right or
		// left you will get a red comm light on the roborio and will say no
		// code

		encoderRightDrive = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		encoderRightDrive.setPIDSourceType(PIDSourceType.kDisplacement);
		encoderRightDrive.setDistancePerPulse(1.0 / tickPerInch);
		encoderRightDrive.reset();

		CameraServer server1 = CameraServer.getInstance();
		
		server1.startAutomaticCapture();

	}

	public Encoder getEncoderRight() {
		return encoderLeftDrive;
	}

	public Encoder geetEncoderLeft() {
		return encoderRightDrive;
	}
}
