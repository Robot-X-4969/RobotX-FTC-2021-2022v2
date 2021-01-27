
 package robotx.opmodes.autonomous;


import android.graphics.RenderNode;

import com.qualcomm.robotcore.eventloop.opmode.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import robotx.modules.MecanumDrive;
import robotx.modules.IntakeSystem;
import robotx.modules.Launcher;
import robotx.modules.LiftSystem;

import static java.lang.Thread.sleep;

@Autonomous(name = "RobotXAutonomous2021", group = "Default")

public class RobotXAutonomous2021 extends LinearOpMode {

    //private ElapsedTime runtime = new ElapsedTime();

    //Modules being imported
    MecanumDrive mecanumDrive;
    IntakeSystem intakeSystem;
    Launcher launcher;
    LiftSystem liftSystem;





@Override

    public void runOpMode () {

        //Text at bottom of phone
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        mecanumDrive = new MecanumDrive(this);
        mecanumDrive.init();

        intakeSystem = new IntakeSystem(this);
        intakeSystem.init();

        launcher = new Launcher(this);
        launcher.init();

        liftSystem = new LiftSystem(this);
        liftSystem.init();


        mecanumDrive.start();
        intakeSystem.start();
        launcher.start();
        liftSystem.start();


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
            liftSystem.clawServo.setPosition(0.38);

            sleep(250);
            StrafeRight(0.6, 1025);
            StopDriving();
            sleep(250);
            DriveBackward(0.6, 1015);
            StopDriving();
            sleep(750);
<<<<<<< HEAD
            PowerShot2(1400, 500);
=======
            PowerShot(1500, 500);
>>>>>>> c71b1010f31978e222252b3ca6346e5d25e04b9b
            StopDriving();
            sleep(500);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            StrafeLeft(0.6, 290);
            StopDriving();
            sleep(750);
            PowerShot2(1400, 500);
            StopDriving();
            sleep(500);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            StrafeLeft(0.6, 370);
            StopDriving();
            sleep(750);
            PowerShot2(1400, 500);
            StopDriving();
            sleep(500);
            launcher.launcherServo.setPosition(0.95);
            sleep(250);
            DriveBackward(0.6, 800);
            StopDriving();
            sleep(750);
            StrafeLeft(0.6, 250);
            LiftMotorOpen(0.6, 2000);
            sleep(500);
            liftSystem.clawServo.setPosition(0.8);
            sleep(500);
            liftSystem.clawServo2.setPosition(0.1);
            sleep(1000);
            //LiftMotorOpen(-0.6,1500);
            DriveForward(0.6,250);
            sleep(10000);





            /*
            DriveBackward(0.6,350);
            StopDriving();
            sleep(250);
            StrafeLeft(1.0, 400);
            StrafeRight(1.0,400);
            StopDriving();
            sleep(250);
            DriveForward(0.6,400);
            sleep(10000);
            */

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

    public void PowerShot(int time, int time2) {
        launcher.launcherMotor.setPower(launcher.powerShot);
        sleep(time);
        launcher.launcherMotor.setPower(launcher.powerShot);
        launcher.launcherServo.setPosition(0.735);
        sleep(time2);
        launcher.launcherMotor.setPower(0);
    }

    public void PowerShot2(int time, int time2) {
        launcher.launcherMotor.setPower(launcher.powerShot2);
        sleep(time);
        launcher.launcherMotor.setPower(launcher.powerShot2);
        launcher.launcherServo.setPosition(0.735);
        sleep(time2);
        launcher.launcherMotor.setPower(0);
    }

    public void SlowerShot(int time) {
        launcher.launcherMotor.setPower(launcher.launcherPower);
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

    public void LiftMotorOpen(double power, int time) {
        liftSystem.liftMotor.setPower(.5);
        sleep(time);
        liftSystem.liftMotor.setPower(0);
    }
}


