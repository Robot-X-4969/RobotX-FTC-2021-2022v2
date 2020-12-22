package robotx.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.*;
import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class DummyProgram extends XModule{

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    double power = 0.6;

    public DummyProgram(OpMode op){
        super(op);
    }

    public void init(){
        //front left motor
        frontLeft = opMode.hardwareMap.dcMotor.get("frontLeftMotor");
        // frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //when moving forward, the two front wheels spin in opposite directions (left is counter-clockwise, right is clockwise)
        //front right motor
        frontRight = opMode.hardwareMap.dcMotor.get("frontRightMotor");
        // frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //back left motor
        backLeft = opMode.hardwareMap.dcMotor.get("backLeftMotor");
        // backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //back right motor
        backRight = opMode.hardwareMap.dcMotor.get("backRightMotor");
        //backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void loop() {
        if (xGamepad1().dpad_up.isDown()) {
            frontLeft.setPower(power);
            frontRight.setPower(-power);
            backLeft.setPower(power);
            backRight.setPower(-power);
        }

        if (xGamepad1().dpad_left.isDown()) {
            frontLeft.setPower(-power);
            frontRight.setPower(-power);
            backLeft.setPower(-power);
            backRight.setPower(-power);
        }

        if (xGamepad1().dpad_right.isDown()) {
            frontLeft.setPower(power);
            frontRight.setPower(power);
            backLeft.setPower(power);
            backRight.setPower(power);
        }

        if (xGamepad1().dpad_down.isDown()) {
            frontLeft.setPower(-power);
            frontRight.setPower(power);
            backLeft.setPower(-power);
            backRight.setPower(power);
        }

        else {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);
        }
    }



}
