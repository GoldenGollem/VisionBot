package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	
    public void initDefaultCommand() {
    }
    public void AimRobot(){
    	if(/*TARGET != null&&*/OI.getOPStick().getRawButton(3)){
    		System.out.println("AIMING NOW");
    		while(/*TARGET.x<=90||TARGET.x>=100&&*/OI.getOPStick().getRawButton(3)){
    			if(/*TARGET.x>100&&*/OI.getOPStick().getRawButton(3)){
    				System.out.println("To The Right");
    				Robot.driveTrain.getDrive().mecanumDrive_Cartesian(0, 0, 0.3, 0);
    				Timer.delay(0.1);
    				Robot.driveTrain.getDrive().drive(0, 0);
    			}else if(/*TARGET.x<90&&*/OI.getOPStick().getRawButton(3)){
    				System.out.println("To The Left");
    				Robot.driveTrain.getDrive().mecanumDrive_Cartesian(0, 0, -0.3, 0);
    				Timer.delay(0.1);
    				Robot.driveTrain.getDrive().drive(0, 0);
    			}else{
    				Robot.driveTrain.getDrive().drive(0, 0);
    				System.out.println("Now Kick");
    			}
        	}
    	}else{
    		System.out.println("NO TARGET");
    	}
    }
    public void DropGear(){
    	
    }
    public double getTargetSpeed(){
		return 0;
    	
    }
}

