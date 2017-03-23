package org.usfirst.frc.team2906.robot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick joystick1;
	public Joystick joystick2;
	public JoystickButton j1b1;
	public JoystickButton j1b2;
	public JoystickButton j1b3;
	public JoystickButton j1b4;
	public JoystickButton j1b5;
	public JoystickButton j1b6;
	public JoystickButton j1b7;
	public JoystickButton j1b8;
	public JoystickButton j1b9;
	public JoystickButton j1b10;
	public JoystickButton j1b11;
	public JoystickButton j1b12;
	public JoystickButton j2b1;
	public JoystickButton j2b2;
	public JoystickButton j2b3;
	public JoystickButton j2b4;
	public JoystickButton j2b5;
	public JoystickButton j2b6;
	public JoystickButton j2b7;
	public JoystickButton j2b8;
	public JoystickButton j2b9;
	public JoystickButton j2b10;
	public JoystickButton j2b11;
	public JoystickButton j2b12;

	
	public OI() {

		joystick2 = new Joystick(1);
		joystick1 = new Joystick(0);
		
		j1b1 = new JoystickButton(joystick1, 1);
		j1b2 = new JoystickButton(joystick1, 2);
		j1b3 = new JoystickButton(joystick1, 3);
		j1b4 = new JoystickButton(joystick1, 4);
		j1b5 = new JoystickButton(joystick1, 5);
		j1b6 = new JoystickButton(joystick1, 6);
		j1b7 = new JoystickButton(joystick1, 7);
		j1b8 = new JoystickButton(joystick1, 8);
		j1b9 = new JoystickButton(joystick1, 9);
		j1b10 = new JoystickButton(joystick1, 10);
		j1b11 = new JoystickButton(joystick1, 11);
		j1b12 = new JoystickButton(joystick1, 12);
		j2b1 = new JoystickButton(joystick2, 1);
		j2b2 = new JoystickButton(joystick2, 2);
		j2b3 = new JoystickButton(joystick2, 3);
		j2b4 = new JoystickButton(joystick2, 4);
		j2b5 = new JoystickButton(joystick2, 5);
		j2b6 = new JoystickButton(joystick2, 6);
		j2b7 = new JoystickButton(joystick2, 7);
		j2b8 = new JoystickButton(joystick2, 8);
		j2b9 = new JoystickButton(joystick2, 9);
		j2b10 = new JoystickButton(joystick2, 10);
		j2b11 = new JoystickButton(joystick2, 11);
		j2b12 = new JoystickButton(joystick2, 12);
	}

	public Joystick getJoystick1() {
		return joystick1;
	}

	public double getJoystick1X() {
		if (Math.abs(joystick1.getX()) > RobotMap.sensitivity) {
			return -1 * joystick1.getX();
		} else {
			return 0.0;
		}
	}

	public double getJoystick1Y() {
		if (Math.abs(joystick1.getY()) > RobotMap.sensitivity) {
			return -1 * joystick1.getY();
		} else {
			return 0.0;
		}
	}

	public Joystick getJoystick2(){
    	return joystick2;
    	}
}
