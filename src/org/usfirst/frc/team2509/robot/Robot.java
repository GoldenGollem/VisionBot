
package org.usfirst.frc.team2509.robot;

import org.usfirst.frc.team2509.robot.commands.OpDrive;
import org.usfirst.frc.team2509.robot.subsystems.Climb;
import org.usfirst.frc.team2509.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2509.robot.subsystems.Shooter;
import org.usfirst.frc.team2509.robot.subsystems.Sweeper;
import org.usfirst.frc.team2509.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static Climb climb;
    public static Drivetrain driveTrain;
    public static Shooter shooter;
    public static Sweeper sweeper;
    public static Vision vision;
	public Command autonomousCommand;
	public Command opDrive;
	public String autoCommand;
	public void robotInit() {
    	RobotMap.init();
    	climb = new Climb();
        driveTrain = new Drivetrain();
        shooter = new Shooter();
        sweeper = new Sweeper();
        vision = new Vision();
    	// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it
		oi = new OI();
		opDrive = new OpDrive();
		RobotMap.UpdateDash.start();
		System.out.println("Robot Ready");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
		System.out.println("Robot Disabled");
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. 
	 */
	public void autonomousInit() {
		System.out.println("Auto Start");
		RobotMap.DT_GYRO.reset();
    	//SmartDashboard.putBoolean("Switch", RobotMap.GEAR_SWITCH.get());
    	autoCommand = oi.CHOOSER.getSelected();
    	autonomousCommand = oi.getAutonomous(autoCommand);
        // schedule the autonomous command (example)
    	if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null){
        	autonomousCommand.cancel();
            if(autonomousCommand.isCanceled())System.out.println("Autonomous Ended");
        }
        if(isEnabled()&&isOperatorControl()) opDrive.start();
		System.out.println("Tele-Op Start");
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Timer.delay(0.005);
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
