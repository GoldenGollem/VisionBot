package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static Joystick OP_STICK;
	private static Joystick COOP_STICK;
    public JoystickButton CLIMB;
    public JoystickButton FORWARD_SWEEP;
    public JoystickButton REVERSE_SWEEP;
    public JoystickButton SHOOT;
    public JoystickButton SHOOT_AIM;
    public String AUTO;
    public String DEFAULT;
    public String BLUE1;
	public String BLUE1S;
	public String BLUE2;
	public String BLUE2S;
	public String BLUE3;
	public String RED1;
	public String RED2;
	public String RED2S;
	public String RED3;
	public String RED3S;
	public SendableChooser<String> CHOOSER;
	private Command autoCommand;
	public OI() {
		//Joysticks
		OP_STICK = new Joystick(0);
		COOP_STICK = new Joystick(1);
		//Joystick Buttons
		CLIMB = new JoystickButton(COOP_STICK, 1);
		CLIMB.whileHeld(null);
		FORWARD_SWEEP = new JoystickButton(COOP_STICK,3);
        FORWARD_SWEEP.whileHeld(null);
        REVERSE_SWEEP = new JoystickButton(COOP_STICK, 5);
        REVERSE_SWEEP.whileHeld(null);
        SHOOT_AIM = new JoystickButton(OP_STICK,3);
        SHOOT_AIM.whileHeld(null);
        SHOOT = new JoystickButton(OP_STICK, 1);
        SHOOT.whileHeld(null);
		//Autonomous Modes
		DEFAULT = "Default";
	    BLUE1 = "Blue 1";
		BLUE1S = "Blue 1S";
		BLUE2 = "Blue 2";
		BLUE2S = "Blue 2S";
		BLUE3 = "Blue 3";
		RED1 = "Red 1";
		RED2  = "Red 2";
		RED2S = "Red 2S";
		RED3 = "Red 3";
		RED3S = "Red 3S";
		//Chooser
		CHOOSER = new SendableChooser<>();
		CHOOSER.addDefault("Default", DEFAULT);
		CHOOSER.addObject("Blue 1", BLUE1);
		CHOOSER.addObject("Blue 1 - Shoot", BLUE1S);
		CHOOSER.addObject("Blue 2", BLUE2);
		CHOOSER.addObject("Blue 2 - Shoot", BLUE2);
		CHOOSER.addObject("Blue 3", BLUE3);
		CHOOSER.addObject("Red 1", RED1);
		CHOOSER.addObject("Red 2", RED2);
		CHOOSER.addObject("Red 2 - Shoot", RED2S);
		CHOOSER.addObject("Red 3", RED3);
		CHOOSER.addObject("Red 3 - Shoot", RED3S);
	}
	public static Joystick getOPStick(){
		return OP_STICK;
	}
	public static Joystick getCOOPStick(){
		return COOP_STICK;
	}
	public static double getScaledX(Joystick stick){
		return (stick.getX()*((stick.getRawAxis(3)+3)*0.25));
	}
	public static double getScaledY(Joystick stick){
		return (stick.getY()*((stick.getRawAxis(3)+3)*0.25));
	}
	public static double getScaledZ(Joystick stick){
		return (stick.getZ()*((stick.getRawAxis(3)+3)*0.25));
	}
	public void putDashboard(){
        SmartDashboard.putData("Climb Up", null);//replace null with command
        SmartDashboard.putData("Shooter Start", null);//replace null with command
        SmartDashboard.putData("ReverseSweep", null);//replace null with command
        SmartDashboard.putData("Forward Sweep", null);//replace null with command
        SmartDashboard.putData("Aim Shooter", null);//replace null with command
        SmartDashboard.putData("Auto choices", CHOOSER);
	}
	public Command getAutonomous(String autoChoice){
		switch(autoChoice){
		case "Blue 1":
   		 	autoCommand = null;
   		 	break;
    	case "Blue 1S":
    		autoCommand = null;
    		break;
    	case "Blue 2":
    		autoCommand = null;
   			break;
    	case "Blue 2S":
    		autoCommand = null;
    		break;
    	case "Blue 3":
    		autoCommand = null;
    		break;
    	case "Red 1":
   		 	autoCommand = null;
   		 	break;
    	case "Red 2":
    		autoCommand = null;
    		break;
    	case "Red 2S":
    		autoCommand = null;
    		break;
    	case "Red 3":
    		autoCommand = null;
    		break;
    	case "Red 3S":
    		autoCommand = null;
    		break;
    	default:
			autoCommand = null;//replace null with command
			break;
    	}
		return autoCommand;
	}
}
