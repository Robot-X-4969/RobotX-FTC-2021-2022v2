 package robotx.modules;

import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSystem extends XModule {

    DcMotor intakeMotor;

    Servo adjustServo;

    double power = 0.8;

    boolean adjusted = false;

    public IntakeSystem (OpMode op) {
        super(op);
    }

    public void init() {
        intakeMotor = opMode.hardwareMap.dcMotor.get("IntakeMotor");
        adjustServo = opMode.hardwareMap.servo.get("adjustServo");
    }

    public void adjustmentServo() {
        if (!adjusted) {

            adjustServo.setPosition(0);
            adjusted = true;
        }
        else {

            adjustServo.setPosition(0.22);
            adjusted = false;
        }
    }0
0
    public void loop() {
        if (xGamepad2().x.isDown()) {
            intakeMotor.setPower(power);
        }

        else if (xGamepad2().y.isDown()) {
            intakeMotor.setPower(-power);
        }

        else {
            intakeMotor.setPower(0.0);
        }

        if (xGamepad1().a.wasPressed()) {
            adjustmentServo();
        }
    }
}
