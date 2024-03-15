package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/**
 * This command will drive the robot based on variable inputs for
 * speed in the x-direction and y-direction, with an applied rotation.
 */
public class DriveCommand extends Command {
    /**
     * The drivetrain used by this command.
     */
    private DriveSubsystem driveSubsystem;

    /**
     * Variable inputs for the mechanic drive.
     */
    private DoubleSupplier xSpeed, ySpeed, zRotation;

    /**
     * Drive based on reactive inputs.
     * 
     * @param driveSubsystem the required drive subsystem
     * @param xSpeed         reactive cartesian speed in the x-direction
     * @param ySpeed         reactive cartesian speed in the y-direction
     * @param zRotation      reactive rotation in degrees
     */
    public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier xSpeed, DoubleSupplier ySpeed,
            DoubleSupplier zRotation) {
        this.driveSubsystem = driveSubsystem;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zRotation = zRotation;

        addRequirements(driveSubsystem);
    }

    /**
     * Request the motors to drive with fixed speeds.
     * 
     * @param driveSubsystem the required drive subsystem
     * @param xSpeed         cartesian speed in the x-direction
     * @param ySpeed         cartesian speed in the y-direction
     * @param zRotation      rotation in degrees
     */
    public DriveCommand(DriveSubsystem driveSubsystem, double xSpeed, double ySpeed, double zRotation) {
        this(driveSubsystem, () -> xSpeed, () -> ySpeed, () -> zRotation);
    }

    /**
     * Request the {@link DriveSubsystem} to drive based on the current value of
     * {@link #xSpeed}, {@link #ySpeed}, and {@link #zRotation}.
     */
    @Override
    public void execute() {
        driveSubsystem.mecanumDrive(this.xSpeed.getAsDouble(), this.ySpeed.getAsDouble(), this.zRotation.getAsDouble());
    }
}
