package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class TeleopArm extends CommandBase {

    private final XboxController controller;
    private final Arm arm;

    public TeleopArm(Arm arm, XboxController controller) {
        this.arm = arm;
        this.controller = controller;
        addRequirements(arm);
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
            arm.tiltForward();
        } else if (controller.getLeftBumper()) {
            arm.tiltBackward();
        }

        // Move gripper with A and B
        if (controller.getBButton()) {
            arm.openGripper();
        } else if (controller.getAButton()) {
            arm.closeGripper();
        }
    }
    
}
