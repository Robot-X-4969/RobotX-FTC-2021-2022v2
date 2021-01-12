
 package robotx.opmodes.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import robotx.libraries.XOpMode;
import robotx.modules.MecanumDrive;
import robotx.modules.IntakeSystem;
import robotx.modules.Launcher;

import static java.lang.Thread.sleep;

@Autonomous(name = "RobotXAutonomous2021", group = "Default")

public class RobotXAutonomous2021 extends LinearOpMode {

    //private ElapsedTime runtime = new ElapsedTime();

    //Modules being imported
    MecanumDrive mecanumDrive;
    IntakeSystem intakeSystem;
    Launcher launcher;


    @Override
    public void runOpMode() {

        //Text at bottom of phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        mecanumDrive = new MecanumDrive(this);
        mecanumDrive.init();

        intakeSystem = new IntakeSystem(this);
        intakeSystem.init();

        launcher = new Launcher(this);
        launcher.init();


        mecanumDrive.start();
        intakeSystem.start();
        launcher.start();

        mecanumDrive.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mecanumDrive.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mecanumDrive.backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        mecanumDrive.backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData(">", "Press Play to Start Op Mode");
        telemetry.update();

        waitForStart();
        //runtime.reset();

        if (opModeIsActive()) {
            //Movement

            StrafeRight(0.6, 975);
            StopDriving();
            sleep(250);
            DriveBackward(0.6, 1015);
            StopDriving();
            sleep(750);
            PowerShot(2000);
            StopDriving();
            sleep(250);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            StrafeLeft(0.6, 290);
            StopDriving();
            sleep(750);
            PowerShot(2000);
            StopDriving();
            sleep(250);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            StrafeLeft(0.6, 370);
            StopDriving();
            sleep(750);
            PowerShot(2000);
            StopDriving();
            sleep(250);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            DriveBackward(0.6, 450);
            StopDriving();
            sleep(250);
            DriveBackward(0.6,350);
            StopDriving();
            sleep(250);
            StrafeLeft(1.0, 400);
            StrafeRight(1.0,400);
            StopDriving();
            sleep(250);
            DriveForward(0.6,400);
            sleep(10000);


        }
    }


        //Controls
     public void DriveForward(double power, int time) {
        mecanumDrive.frontLeft.setPower(-power);
        mecanumDrive.frontRight.setPower(-power);
        mecanumDrive.backLeft.setPower(-power);
        mecanumDrive.backRight.setPower(-power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void DriveBackward(double power, int time) {
        mecanumDrive.frontLeft.setPower(power);
        mecanumDrive.frontRight.setPower(power);
        mecanumDrive.backLeft.setPower(power);
        mecanumDrive.backRight.setPower(power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void StrafeLeft(double power, int time) {
        mecanumDrive.frontLeft.setPower(power);
        mecanumDrive.frontRight.setPower(-power);
        mecanumDrive.backLeft.setPower(-power);
        mecanumDrive.backRight.setPower(power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void StrafeRight(double power, int time) {
        mecanumDrive.frontLeft.setPower(-power);
        mecanumDrive.frontRight.setPower(power);
        mecanumDrive.backLeft.setPower(power);
        mecanumDrive.backRight.setPower(-power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void TurnLeft(double power, int time) {
        mecanumDrive.frontLeft.setPower(-power);
        mecanumDrive.frontRight.setPower(power);
        mecanumDrive.backLeft.setPower(-power);
        mecanumDrive.backRight.setPower(power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void TurnRight(double power, int time) {
        mecanumDrive.frontLeft.setPower(power);
        mecanumDrive.frontRight.setPower(-power);
        mecanumDrive.backLeft.setPower(power);
        mecanumDrive.backRight.setPower(-power);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }

    public void PowerShot(int time) {
        launcher.launcherMotor.setPower(launcher.powerShotPower);
        launcher.launcherServo.setPosition(0.735);
        sleep(time);
        launcher.launcherMotor.setPower(0);
    }

    public void StopDriving() {
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }
    public void SlowDownBack(double power, int time){
        mecanumDrive.frontLeft.setPower(-.3);
        mecanumDrive.frontRight.setPower(-.3);
        mecanumDrive.backRight.setPower(-.3);
        mecanumDrive.backLeft.setPower(-.3);
        sleep(time);
        mecanumDrive.frontLeft.setPower(0);
        mecanumDrive.frontRight.setPower(0);
        mecanumDrive.backLeft.setPower(0);
        mecanumDrive.backRight.setPower(0);
    }
}
