package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.BaseRobot;
import org.firstinspires.ftc.teamcode.hardware.Control;
import org.firstinspires.ftc.teamcode.hardware.Devices;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

@TeleOp

public class SampleTeleOp extends BaseRobot {

    private ElapsedTime timer = new ElapsedTime();
    double servoPower = 1.0;
    private int servoVariable = 0;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void loop() {
        super.loop();

        // drive using tankanum
        Control.drive.tankanumDrive(gamepad1.right_stick_y, gamepad1.left_stick_y, gamepad1.right_stick_x);

        // control armLiftMotor
        if (gamepad1.dpad_up) {
            Control.motor.moveMotor(Devices.armLiftMotor, 0.5);
        } else if (gamepad1.dpad_down) {
            Control.motor.moveMotor(Devices.armLiftMotor, -0.5);
        } else if (gamepad1.dpad_right) {
            Control.motor.moveMotor(Devices.armLiftMotor, 0.15);
        } else if (gamepad1.dpad_left) {
            Control.motor.moveMotor(Devices.armLiftMotor, -0.15);
        } else {
            Control.motor.moveMotor(Devices.armLiftMotor, 0.0);
        }

        // control servoLiftMotor
        if (gamepad1.b && timer.seconds() > 1) {
            Control.servo.setServoPosition(Devices.armAdjustServo, servoPower);
            timer.reset();
            servoPower = Math.abs(servoPower - 1.0);

//            if (servoVariable == 0) {
//                servoVariable = 1;
//            } else if (servoVariable == 1) ;
//            Control.servo.setServoPosition(Devices.armAdjustServo, 0.5);
//            servoVariable = 0;

        }

            //control carouselServo
            Devices.carouselServo.setPower(-gamepad1.left_trigger);




        //control intakeMotor
        Control.motor.moveMotor(Devices.intakeMotor, gamepad1.right_trigger);

        //control conveyorMotor

        Control.motor.moveMotor(Devices.conveyorMotor, gamepad1.right_trigger);

    }


}



