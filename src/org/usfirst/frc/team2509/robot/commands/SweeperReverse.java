package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SweeperReverse extends Command {

    public SweeperReverse() {
        requires(Robot.sweeper);
    }


    protected void initialize() {
    	Robot.sweeper.Reverse();
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
