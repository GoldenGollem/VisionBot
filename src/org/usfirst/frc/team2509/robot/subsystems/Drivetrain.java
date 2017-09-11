package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private final RobotDrive DRIVETRAIN = RobotMap.DRIVETRAIN;
	private final CANTalon LEFT_FRONT = RobotMap.DT_LEFTFRONT;
    private final CANTalon RIGHT_FRONT = RobotMap.DT_RIGHTFRONT;
    private final CANTalon LEFT_REAR = RobotMap.DT_LEFTREAR;
    private final CANTalon RIGHT_REAR = RobotMap.DT_RIGHTREAR;
    private final ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
    public void initDefaultCommand() {}
    public void OperatorControl(){
    	DRIVETRAIN.mecanumDrive_Cartesian(OI.getScaledX(OI.getOPStick()), OI.getScaledY(OI.getOPStick()), OI.getScaledZ(OI.getOPStick()),0);
    }
    public void AltOperatorControl(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, OI.getScaledY(OI.getOPStick()), OI.getScaledZ(OI.getOPStick()),0);
    }
    public void ReverseOperatorControl(){
    	DRIVETRAIN.mecanumDrive_Cartesian((OI.getScaledX(OI.getOPStick())*(-1)), (OI.getScaledY(OI.getOPStick())*(-1)), OI.getScaledZ(OI.getOPStick()),0);
    }
    public void AltReverseOperatorControl(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, (OI.getScaledY(OI.getOPStick())*(-1)), OI.getScaledZ(OI.getOPStick()),0);
    }
    public void Rotate(double Angle){
    	System.out.println("Target Angle: " + Angle);
    	if(GYRO.getAngle()<Angle){
    		while(GYRO.getAngle()<Angle) DRIVETRAIN.mecanumDrive_Cartesian(0, 0, 0.4, 0);
	    	if(GYRO.getAngle()<(Angle)) DRIVETRAIN.drive(0, 0);
	    	System.out.println("Robot Turned To " + GYRO.getAngle());
		}else if(GYRO.getAngle()>Angle){
			while(GYRO.getAngle()>Angle) DRIVETRAIN.mecanumDrive_Cartesian(0, 0, -0.4, 0);
	    	if(GYRO.getAngle()>(Angle)) DRIVETRAIN.drive(0, 0);
	    	System.out.println("Robot Turned To " + GYRO.getAngle());
		}
    }
    public void AutoBoiler_1(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, 0.75, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 1");
     	Timer.delay(1.2);
     	DRIVETRAIN.drive(0, 0);
    }
    public void AutoBoiler_2(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 2");
     	Timer.delay(.3);
     	DRIVETRAIN.drive(0, 0);
    }
    public void AutoBoiler_3(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, -0.75, 0, 0);
 	    Timer.delay(0.75);
 	    DRIVETRAIN.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    public void AutoCenter_1(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 1");
		Timer.delay(1.15);
		DRIVETRAIN.drive(0,0);
    }
    public void AutoCenter_2(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, -0.75, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 2");
	    Timer.delay(0.3);
	    DRIVETRAIN.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    public void AutoCenter_3(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, -0.75, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 3");
	    Timer.delay(0.9);
	    DRIVETRAIN.drive(0, 0);
    }
    public void AutoHopper_1(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, 0.75, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 1");
     	Timer.delay(1.2);
     	DRIVETRAIN.drive(0, 0);
    }
    public void AutoHopper_2(){
    	DRIVETRAIN.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    	System.out.println(Timer.getMatchTime()+" - Auto Part 2");
     	Timer.delay(.3);
     	DRIVETRAIN.drive(0, 0);
    }
    public RobotDrive getDrive(){
    	return DRIVETRAIN;
    }
    public CANTalon getLeftFront(){
    	return LEFT_FRONT;
    }
    public CANTalon getLeftRear(){
    	return LEFT_REAR;
    }
    public CANTalon getRightFront(){
    	return RIGHT_FRONT;
    }
    public CANTalon getRightRear(){
    	return RIGHT_REAR;
    }
    public ADXRS450_Gyro getGyro(){
    	return GYRO;
    }
}

