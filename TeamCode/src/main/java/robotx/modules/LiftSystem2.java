package robotx.modules;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import robotx.libraries.XModule;
public class LiftSystem2 extends XModule {

    public Servo leftClawServo;
    public Servo rightClawServo;
    public DcMotor armMotor;

    double power = 0.8;
    public double armPower = 0.7;

    public LiftSystem2(OpMode op) {
        super(op);
    }

    public void init() {

        leftClawServo = opMode.hardwareMap.servo.get("LeftClawServo");
        rightClawServo = opMode.hardwareMap.servo.get("RightClawServo");
        armMotor = opMode.hardwareMap.dcMotor.get("ArmMotor");
    }

    public void loop() {

        if (xGamepad2().a.isDown()) {
            leftClawServo.setPosition(0.41);
            rightClawServo.setPosition(0.45);
        }
        else if (xGamepad2().b.isDown()) {
            leftClawServo.setPosition(0.0);
            rightClawServo.setPosition(0.01);
        }

        if (xGamepad2().right_bumper.isDown()){
            armMotor.setPower(-armPower);
        }

        else if (xGamepad2().left_bumper.isDown()) {
            armMotor.setPower(armPower);
        }

        else {
            armMotor.setPower(0.0);
        }
    }
}