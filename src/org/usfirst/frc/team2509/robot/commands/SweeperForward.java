package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SweeperForward extends Command {
    public SweeperForward() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.sweeper);
    }


    protected void initialize() {
    	Robot.sweeper.Forward();
    }


    protected void execute() {
    }


    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    	Robot.sweeper.Stop();
    }


    protected void interrupted() {
    	end();
    }
}
