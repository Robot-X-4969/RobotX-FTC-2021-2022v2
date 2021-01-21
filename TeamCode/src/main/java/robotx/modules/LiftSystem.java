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
    Servo clawServo2;

    double power = -0.4;

    boolean clawOpen = false;

    public LiftSystem (OpMode op) {
        super(op);
    }

    public void init() {

        liftMotor = opMode.hardwareMap.dcMotor.get("LiftMotor");
        liftServo = opMode.hardwareMap.servo.get("LiftServo");
        clawServo = opMode.hardwareMap.servo.get("ClawServo");
        clawServo2 = opMode.hardwareMap.servo.get("ClawServo2");
    }

    public void clawServo() {
        if(clawOpen == false) {
            clawServo.setPosition(0.8);
            clawOpen = true;
        }
        else {
            clawServo.setPosition(0.42);
            clawOpen = false;
        }
    }
    /*public void clawServo2(){
        if(clawOpen == false){
            clawServo2.setPosition(0.1);
            clawOpen = true;
        }
        else{
            clawServo2.setPosition(0.267);
            clawOpen = false;
        }
    }*/

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
            clawServo2.setPosition(0.1);
        }

        else if (xGamepad2().b.isDown()) {
            clawServo2.setPosition(0.267);
        }

        else {
            liftServo.setPosition(0.232);
        }

        if (xGamepad2().dpad_left.wasPressed()) {
            clawServo();
        }

    }
}
//Open: 0.1
//Close: 0.267





