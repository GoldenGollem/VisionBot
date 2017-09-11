package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

/**
 * Motor Controller Values
 *  C4 - Climb Motor 1
 *  C7 - Climb Motor 2
 *  C2 - DT Front Left
 *  C1 - DT Front Right
 *  C0 - DT Rear Left 
 *  C3 - DT Rear Right
 *  T1 - Shooter Auger
 *  T0 - Shooter Gate
 *  C6 - Shooter Motor
 *  C5 - Sweeper Motor
 */
public class RobotMap {
	//
    public static RobotDrive DRIVETRAIN;
    //Motors
	public static CANTalon CLIMB_MOTOR1;
    public static CANTalon CLIMB_MOTOR2;
    public static CANTalon DT_LEFTFRONT;
    public static CANTalon DT_RIGHTFRONT;
    public static CANTalon DT_LEFTREAR;
    public static CANTalon DT_RIGHTREAR;
    public static Talon SHOOT_AUGER;
    public static Talon SHOOT_GATE;
    public static CANTalon SHOOT_MOTOR;
    public static CANTalon SWEEP_MOTOR;
    //Sensors    
    public static ADXRS450_Gyro DT_GYRO;
    public static Encoder SHOOT_ENCODER;
    //Other
    public static Thread UpdateDash;
    public static void init() {
    	DRIVETRAIN = new RobotDrive(DT_LEFTFRONT, DT_LEFTREAR,DT_RIGHTFRONT, DT_RIGHTREAR);
        DRIVETRAIN.setSafetyEnabled(false);
        DRIVETRAIN.setExpiration(1.0);
        DRIVETRAIN.setSensitivity(1.0);
        DRIVETRAIN.setMaxOutput(1.0);
        DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    	
    	CLIMB_MOTOR1 = new CANTalon(4);
    	CLIMB_MOTOR1.setInverted(true);
    	LiveWindow.addActuator("Climb", "Motor 1", CLIMB_MOTOR1);
    	CLIMB_MOTOR2 = new CANTalon(7);
    	CLIMB_MOTOR2.setInverted(true);
    	LiveWindow.addActuator("Climb", "Motor 2", CLIMB_MOTOR2);
    	DT_LEFTFRONT = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "DT_LEFTFRONT", DT_LEFTFRONT);
        DT_RIGHTFRONT = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "DT_RIGHTFRONT", DT_RIGHTFRONT);
        DT_LEFTREAR = new CANTalon(0);
        LiveWindow.addActuator("DriveTrain", "DT_LEFTREAR", DT_LEFTREAR);
        DT_RIGHTREAR = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "DT_RIGHTREAER", DT_RIGHTREAR);
        SHOOT_AUGER = new Talon(1);
        LiveWindow.addActuator("Shooter", "Auger", SHOOT_AUGER);
        SHOOT_GATE = new Talon(0);
        SHOOT_GATE.setInverted(true);
        LiveWindow.addActuator("Shooter", "Gate", SHOOT_GATE);
        SHOOT_MOTOR = new CANTalon(6);
        SHOOT_MOTOR.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        SHOOT_MOTOR.reverseSensor(false);
        SHOOT_MOTOR.configNominalOutputVoltage(+0.0f, -0.0f);
        SHOOT_MOTOR.configPeakOutputVoltage(+12.0f, -12.0f);
        SHOOT_MOTOR.setProfile(0); 
        SHOOT_MOTOR.setF(0);
        SHOOT_MOTOR.setP(0.04);
        SHOOT_MOTOR.setI(0.0002);
        SHOOT_MOTOR.setD(0.0001);
        SHOOT_MOTOR.changeControlMode(TalonControlMode.Speed);
        LiveWindow.addActuator("Shooter", "Motor", (CANTalon) SHOOT_MOTOR);
        SWEEP_MOTOR = new CANTalon(5);
        LiveWindow.addActuator("Sweeper", "Motor", (CANTalon) SWEEP_MOTOR);
        
        DT_GYRO = new ADXRS450_Gyro();
       	DT_GYRO.reset();
       	DT_GYRO.calibrate();
        LiveWindow.addSensor("DriveTrain", "DT_GYRO", DT_GYRO);
        
        UpdateDash = new Thread(()->{
        	SmartDashboard.putNumber("Gyro", DT_GYRO.getAngle());
            //SmartDashboard.putDouble("GYRO", RobotMap.DT_GYRO.getAngle());
        	SmartDashboard.putNumber("Encoder", SHOOT_MOTOR.getSpeed());
        });
    }
    
}
