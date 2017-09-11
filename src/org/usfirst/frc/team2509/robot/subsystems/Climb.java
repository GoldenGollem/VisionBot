package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Climb extends Subsystem {

	private final CANTalon MOTOR1 = RobotMap.CLIMB_MOTOR1;
	private final CANTalon MOTOR2 = RobotMap.CLIMB_MOTOR2;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Down(){
    	MOTOR1.set(-1.0);
    	MOTOR2.set(-1.0);
    }
    public void Stop(){
    	MOTOR1.set(0.0);
    	MOTOR2.set(0.0);
    }
    public void Up(){
    	MOTOR1.set(1.0);
    	MOTOR2.set(1.0);
    }
    public CANTalon getMotor1(){
    	return MOTOR1;
    }
    public CANTalon getMotor2(){
    	return MOTOR2;
    }
    
    
}

