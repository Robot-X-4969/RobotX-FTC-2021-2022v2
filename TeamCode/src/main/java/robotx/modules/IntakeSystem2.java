package robotx.modules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import robotx.libraries.XModule;

public class IntakeSystem2 extends XModule {

    public DcMotor intakeMotor;

    public Servo blockServo;
    public Servo adjustServo;
    public Servo pushServo;

    public double power = 1.0;

    boolean adjusted = false;
    boolean block = false;

    public IntakeSystem2(OpMode op) {
        super(op);
    }

    public void init() {
        intakeMotor = opMode.hardwareMap.dcMotor.get("IntakeMotor");

        blockServo = opMode.hardwareMap.servo.get("BlockServo");
        adjustServo = opMode.hardwareMap.servo.get("AdjustServo");
        pushServo = opMode.hardwareMap.servo.get("PushServo");
    }

    private void delay(double n) {
        for (double k = 1; k < n; k += 0.001);
    }

    public void adjustmentServo() {
        if (!adjusted) {
            adjustServo.setPosition(0.182);
            adjusted = true;
        }
        else {
            adjustServo.setPosition(0.15399);
            adjusted = false;
        }
    }

    public void blockServo() {
        if (block) {
            block = false;
            blockServo.setPosition(0.84);

        }
        else {
            block = true;
            blockServo.setPosition(0.62);
        }
    }

   /* public void pushServo() {
        if (pushed) {
            pushed = false;
            pushServo.setPosition();
        }
    }*/

    public void loop() {
        if (xGamepad2().y.isDown()) {
            intakeMotor.setPower(power);
        }
        else if (xGamepad2().x.isDown()) {
            intakeMotor.setPower(-power);
        }
        else {
            intakeMotor.setPower(0.0);
        }

        if (xGamepad1().right_stick_button.wasPressed()) {
            adjustmentServo();
        }

        if (xGamepad2().dpad_left.wasPressed()) {
            blockServo();
        }

        if (xGamepad2().right_stick_button.wasPressed()) {
            pushServo.setPosition(1.0);
        }

        if (xGamepad2().left_stick_button.wasPressed()) {
            pushServo.setPosition(0.461);
        }
    }
}

// .461 - push servo all the way down
// .6359 - push servo in the middle
// 1.0 - push servo all the way up

