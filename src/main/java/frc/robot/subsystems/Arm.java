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
    public static final double LIFT_MIN = 10;
    public static final double LIFT_MAX = 90;
    public static final double TILT_MIN = 90;
    public static final double TILT_MAX = 145;
    public static final double GRIPPER_MIN = 10;
    public static final double GRIPPER_MAX = 170;

    // Servos that move the arm
    private final Servo gripper = new Servo(2);
    private final Servo lift = new Servo(3);
    private final Servo tilt = new Servo(4);

    // Current requested positions for the servos
    private double liftAngle = LIFT_MAX;
    private double tiltAngle = TILT_MAX;
    private double gripperAngle = GRIPPER_MIN;

    @Override
    public void periodic() {
        // Send current requested positions to the SmartDashboard
        SmartDashboard.putNumber("Lift Angle", liftAngle);
        SmartDashboard.putNumber("Tilt Angle", tiltAngle);
        SmartDashboard.putNumber("Gripper Angle", gripperAngle);

        setLift(liftAngle);
        setTilt(tiltAngle);
        setGripper(gripperAngle);
    }

    /**
     * Raise the lift by 1-degree
     */
    public void raiseLift() {
        liftAngle--;
    }

    /**
     * Lower the lift by 1-degree
     */
    public void lowerLift() {
        liftAngle++;
    }

    /**
     * Set the lift angle. Should be a value between {@link #LIFT_MIN} and {@link #LIFT_MAX}.
     * @param angle angle to set
     */
    public void setLift(double angle) {
        liftAngle = MathUtil.clamp(angle, LIFT_MIN, LIFT_MAX);
        lift.setAngle(liftAngle);
    }

    /**
     * Tilt the lift forward 1-degree
     */
    public void tiltUp() {
        tiltAngle ++;
    }

    /**
     * Tilt the lift backward 1-degree
     */
    public void tiltDown() {
        tiltAngle--;
    }

    /**
     * Set the lift tilt angle. Should be a value between {@link #TILT_MIN} and {@link #TILT_MAX}
     * @param angle angle to set
     */
    public void setTilt(double angle) {
        tiltAngle = MathUtil.clamp(angle, TILT_MIN, TILT_MAX);
        tilt.setAngle(tiltAngle);
    }

    /**
     * Open the gripper 1-degree
     */
    public void openGripper() {
        gripperAngle--;
    }

    /** 
     * Close the gripper 1-degree
     */
    public void closeGripper() {
        gripperAngle++;
    }

    /**
     * Set the gripper angle. Should be a value between {@link #GRIPPER_MIN} and {@link #GRIPPER_MAX}
     * @param angle
     */
    public void setGripper(double angle) {
        gripperAngle = MathUtil.clamp(angle, GRIPPER_MIN, GRIPPER_MAX);
        gripper.setAngle(gripperAngle);
    }

}
