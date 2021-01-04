package robotx.modules;

import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class
 LiftSystem extends XModule {

    DcMotor liftMotor;

    Servo liftServo;
    Servo clawServo;

    double power = 0.7;

    boolean clawOpen = false;

    public LiftSystem (OpMode op) {
        super(op);
    }

    public void init() {

        liftMotor = opMode.hardwareMap.dcMotor.get("LiftMotor");
        liftServo = opMode.hardwareMap.servo.get("LiftServo");
        clawServo = opMode.hardwareMap.servo.get("ClawServo");
    }

    public void clawServo() {
        if (clawOpen == false) {
            clawServo.setPosition(0.749);
            clawOpen = true;
        }
        else {
            clawServo.setPosition(0.38);
            clawOpen = false;
        }
    }

    public void loop() {
        if (xGamepad2().dpad_up.isDown()) {
            liftMotor.setPower(power);
        }

        else if (xGamepad2().dpad_down.isDown()) {
            liftMotor.setPower(-power);
        }

        else {
            liftMotor.setPower(0.0);
        }

        if (xGamepad2().a.isDown()) {
            liftServo.setPosition(0.07);
        }

        else if (xGamepad2().b.isDown()) {
            liftServo.setPosition(0.142);
        }

        else {
            liftServo.setPosition(0.224);
        }

        if (xGamepad2().dpad_left.wasPressed()) {
            clawServo();
        }

    }
}