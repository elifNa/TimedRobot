// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Motor controllers
  private final Spark leftMotor1 = new Spark(0);
  private final Spark leftMotor2 = new Spark(1);
  private final Spark rightMotor1 = new Spark(2);
  private final Spark rightMotor2 = new Spark(3);

  // Differential drive system
  private DifferentialDrive drivetrain;

  // Xbox controller
  private final XboxController controller = new XboxController(0);

  @Override
  public void robotInit() {
    // Group the left and right motors
    var leftMotors = new edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup(leftMotor1, leftMotor2);
    var rightMotors = new edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup(rightMotor1, rightMotor2);

    // Invert the right motors for proper movement
    rightMotors.setInverted(true);

    // Initialize the drivetrain
    drivetrain = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void teleopPeriodic() {
    // Get joystick input
    double ySpeed = -controller.getLeftY(); // Forward/backward movement
    double xSpeed = controller.getRightX(); // Rotation

    // Drive the robot using arcade drive
    drivetrain.arcadeDrive(ySpeed, xSpeed);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
