package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class TeleopArm extends Command {

    private final XboxController controller;
    private final Arm arm;

    public TeleopArm(Arm arm, XboxController controller) {
        this.arm = arm;
        this.controller = controller;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        // Move the servos one notch so they will move.
        // If commanded to a position while the robot is disabled, they don't move to that position on enable.
        //The position needs to be changed.
        arm.raiseLift();
        arm.tiltDown();
        arm.closeGripper();
    }

    @Override
    public void execute() {
        // Move lift with X and Y
        if (controller.getYButton()) {
            arm.raiseLift();
        } else if (controller.getXButton()) {
            arm.lowerLift();
        }

        // Move tilt with bumpers
        if (controller.getRightBumper()) {
            arm.tiltUp();
        } else if (controller.getLeftBumper()) {
            arm.tiltDown();
        }

        // Move gripper with A and B
        if (controller.getBButton()) {
            arm.openGripper();
        } else if (controller.getAButton()) {
            arm.closeGripper();
        }
    }
    
}
