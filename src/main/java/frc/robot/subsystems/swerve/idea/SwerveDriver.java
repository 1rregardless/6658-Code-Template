// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.swerve.idea;


import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.subsystems.telnet.TunableController;
import frc.robot.Constants;

/** Add your docs here. */
public class SwerveDriver {
    private double c_dSPeed;
    private double direction_X, direction_Y;
    public TunableController angleController;
    //The higher you want the "top speed" (i.e the speed where the tanh function becomes very close to its limits) the lower dSpeed should be set
    public SwerveDriver (double x, double y, double dSpeed, double aKp, double aKi, double aKd) {
        angleController = new TunableController(aKp, aKi, aKd, "swerveAngle");
        c_dSPeed = dSpeed;
        direction_X = x;
        direction_Y = y;


    }

    private double calculateAngleMeasure() {
        return Math.toDegrees(Math.atan(direction_Y/direction_X));


    }

    public double calculateDrive () {
        return Math.tanh(
            Math.sqrt(Math.pow(direction_X, 2) + Math.pow(direction_Y, 2)) * c_dSPeed
        );

    }
    //output is pure encoder value
    public double calculateAngle (double output) {
        return angleController.calculate(output/(360/Constants.c_SwervePoCEncoderPerRotation), calculateAngleMeasure());

    }
    public double calculateAngle(double output, double gyroAngle) {
        return angleController.calculate((output-gyroAngle)/(360/Constants.c_SwervePoCEncoderPerRotation), calculateAngleMeasure());


    }

}
