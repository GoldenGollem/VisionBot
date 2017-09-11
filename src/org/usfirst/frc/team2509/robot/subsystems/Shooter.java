package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class Shooter extends Subsystem {
	private final Talon AUGER = RobotMap.SHOOT_AUGER;
	private final Talon GATE = RobotMap.SHOOT_GATE;
	private final CANTalon SHOOT = RobotMap.SHOOT_MOTOR;

    public void initDefaultCommand() {}
    public void StartShooter(int TargetSpeed){
    	System.out.println("Shooter Set: "+TargetSpeed);
    	SHOOT.set(TargetSpeed);
    	System.out.println("SHOOTER STARTING");
    }
    public void StopShooter(){
    	SHOOT.changeControlMode(TalonControlMode.PercentVbus);
    	SHOOT.set(0);
    	SHOOT.changeControlMode(TalonControlMode.Speed);
    	System.out.println("SHOOTER STOP");
    }
    public void StartAuger(){
    	AUGER.set(0.5);
    	System.out.println("AUGER STARTING");
    }
    public void StopAuger(){
    	AUGER.set(0);
    	System.out.println("AUGER STOP");
    }
    public void OpenGate(){
    	GATE.set(0.6);
    	Timer.delay(0.125);
		System.out.println("GATE OPENING");
    	GATE.set(0);
    }
    public void CloseGate(){
    	GATE.set(-0.6);
    	Timer.delay(0.125);
		System.out.println("GATE CLOSING");
    	GATE.set(0.0);
    }
    public Talon getAuger(){
    	return AUGER;
    }
    public Talon getGate(){
    	return GATE;
    }
    public CANTalon getShoot(){
    	return SHOOT;
    }
    public Double getRPM(){
    	return SHOOT.getSpeed();
    }
}

