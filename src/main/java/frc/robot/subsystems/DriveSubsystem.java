package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The drivetrain subsystem.
 */
public class DriveSubsystem extends SubsystemBase {
    /**
     * The motors, wired via PWM to the Roborio.
     */
    private Spark frontLeft, frontRight, backLeft, backRight;
    
    /**
     * A built-in class that deals with all the math required use a Mecanum drive
     * base.
     */
    private MecanumDrive drive;

    /**
     * Create the drivetrain.
     */
    public DriveSubsystem() {
        /*
         * Initialize motors with their respective PWM ports.
         */
        this.frontLeft = new Spark(2);
        this.backLeft = new Spark(3);
        this.frontRight = new Spark(1);
        this.backRight = new Spark(0);

        /*
         * The right side needs to be inverted so that the robot drives straight.
         */
        this.frontRight.setInverted(true);
        this.backRight.setInverted(true);

        /*
         * Initialize MecanumDrive helper.
         */
        this.drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    }

    /**
     * Exposed API to let code in this project to control how the drivebase moves.
     * 
     * This function will set the speed of the motors to a specific speed instantly.
     * The motors will keep that speed until manually changed or turned off.
     * 
     * @param xSpeed    the speed in the x-direction [-1.0..1.0]. Forward is
     *                  positive.
     * @param ySpeed    the speed in the y-direction [-1.0..1.0]. Left is positive.
     * @param zRotation the rotation in degrees [-1.0..1.0]. Counterclockwise is
     *                  positive.
     */
    public void mecanumDrive(double xSpeed, double ySpeed, double zRotation) {
        this.drive.driveCartesian(xSpeed, ySpeed, zRotation);
    }
}
