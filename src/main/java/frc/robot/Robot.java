package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is part of the default skeleton.
 * Don't change unless you need to extend a feature!
 */
public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    this.robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    this.autonomousCommand = robotContainer.getAutonomousCommand();

    if (this.autonomousCommand != null) {
      this.autonomousCommand.schedule();
    }
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }
}
