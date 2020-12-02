package robotx.modules;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import robotx.libraries.OmniDriveSystem;

/**
 * Created by WB on 9/24/2018.
 */

public class MecanumDrive extends OmniDriveSystem {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    double frontRightPower = (getYPower() - getXPower() + getRotationPower());
    double frontLeftPower = (getYPower() + getXPower() - getRotationPower());
    double backRightPower = (getYPower() + getXPower() + getRotationPower());
    double backLeftPower = (getYPower() - getXPower() - getRotationPower());

    double halfFrontRightPower = frontRightPower * 0.6;
    double halfFrontLeftPower = frontLeftPower * 0.6;
    double halfBackRightPower = backRightPower * 0.6;
    double halfBackLeftPower = backLeftPower * 0.6;

    public MecanumDrive(OpMode op) {
        super(op);
    }

    public void init(){
        frontLeft = opMode.hardwareMap.dcMotor.get("frontLeft");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight = opMode.hardwareMap.dcMotor.get("frontRight");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft = opMode.hardwareMap.dcMotor.get("backLeft");
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight = opMode.hardwareMap.dcMotor.get("backRight");
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void updateMotors(){
        opMode.telemetry.addData("frontRight", getYPower() - getXPower() - getRotationPower());
        frontRight.setPower(halfFrontRightPower);
        opMode.telemetry.addData("frontLeft", getYPower() + getXPower() + getRotationPower());
        frontLeft.setPower(halfFrontLeftPower);
        opMode.telemetry.addData("backRight", getYPower() + getXPower() - getRotationPower());
        backRight.setPower(halfBackRightPower);
        opMode.telemetry.addData("backLeft", getYPower() - getXPower() + getRotationPower());
        backLeft.setPower(halfBackLeftPower);
    }
}