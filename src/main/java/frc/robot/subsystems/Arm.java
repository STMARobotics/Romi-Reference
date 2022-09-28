package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Subsystem for Romi arm
 */
public class Arm extends SubsystemBase {

    // Constants for min-max arm movments
    public static final double LIFT_MIN = 0;
    public static final double LIFT_MAX = 180;
    public static final double TILT_MIN = 0;
    public static final double TILT_MAX = 180;
    public static final double GRIPPER_MIN = 0;
    public static final double GRIPPER_MAX = 180;

    // Servos that move the arm
    private final Servo lift = new Servo(2);
    private final Servo tilt = new Servo(3);
    private final Servo gripper = new Servo(4);

    // Current requested positions for the servos
    private double liftAngle = 0;
    private double tiltAngle = 0;
    private double gripperAngle = 0;

    @Override
    public void periodic() {
        // Send current requested positions to the SmartDashboard
        SmartDashboard.putNumber("Lift Angle", liftAngle);
        SmartDashboard.putNumber("Tilt Angle", tiltAngle);
        SmartDashboard.putNumber("Gripper Angle", gripperAngle);
    }

    /**
     * Raise the lift by 1-degree
     * @return new lift angle
     */
    public double raiseLift() {
        return setLift(liftAngle + 1);
    }

    /**
     * Lower the lift by 1-degree
     * @return new lift angle
     */
    public double lowerLift() {
        return setLift(liftAngle - 1);
    }

    /**
     * Set the lift angle. Should be a value between {@link #LIFT_MIN} and {@link #LIFT_MAX}.
     * @param angle angle to set
     * @return new lift angle
     */
    public double setLift(double angle) {
        liftAngle = MathUtil.clamp(angle, LIFT_MIN, LIFT_MAX);
        lift.setAngle(liftAngle);
        return liftAngle;
    }

    /**
     * Tilt the lift forward 1-degree
     * @return new tilt angle
     */
    public double tiltForward() {
        return setTilt(tiltAngle + 1);
    }

    /**
     * Tilt the lift backward 1-degree
     * @return new tilt angle
     */
    public double tiltBackward() {
        return setTilt(tiltAngle - 1);
    }

    /**
     * Set the lift tilt angle. Should be a value between {@link #TILT_MIN} and {@link #TILT_MAX}
     * @param angle angle to set
     * @return new tilt angle
     */
    public double setTilt(double angle) {
        tiltAngle = MathUtil.clamp(angle, TILT_MIN, TILT_MAX);
        tilt.setAngle(tiltAngle);
        return tiltAngle;
    }

    /**
     * Open the gripper 1-degree
     * @return new gripper angle
     */
    public double openGripper() {
        return setGripper(gripperAngle + 1);
    }

    /** 
     * Close the gripper 1-degree
     * @return new gripper angle
     */
    public double closeGripper() {
        return setGripper(gripperAngle - 1);
    }

    /**
     * Set the gripper angle. Should be a value between {@link #GRIPPER_MIN} and {@link #GRIPPER_MAX}
     * @param angle
     * @return
     */
    public double setGripper(double angle) {
        gripperAngle = MathUtil.clamp(angle, GRIPPER_MIN, GRIPPER_MAX);
        gripper.setAngle(gripperAngle);
        return gripperAngle;
    }

}
