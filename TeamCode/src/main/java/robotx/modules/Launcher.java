package robotx.modules;
import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Launcher extends XModule {

    public DcMotor launcherMotor;

    public Servo launcherServo;

    double launcherPower = 0.8;
    public double powerShotPower = 0.9;
    public double powerShot = 0.7;
    boolean launcherOn = false;

    public Launcher(OpMode op) {
        super(op);
    }

    public void init() {

        launcherMotor = opMode.hardwareMap.dcMotor.get("LauncherMotor");

        launcherServo = opMode.hardwareMap.servo.get("LauncherServo");
    }

    public void launcherMotor() {
        if (launcherOn) {
            launcherOn = false;
            launcherMotor.setPower(0);

        }
        else {
            launcherOn = true;
            launcherMotor.setPower(launcherPower);
        }
    }

    public void loop() {

        if (xGamepad2().dpad_right.wasPressed()) {
            launcherMotor();
        }

        else if (xGamepad2().left_stick_button.isDown()) {
            launcherMotor.setPower(powerShot);
        }

        if (xGamepad2().right_bumper.wasPressed()) {
            launcherServo.setPosition(0.735);
        }

        else if (xGamepad2().left_bumper.wasPressed()) {
            launcherServo.setPosition(0.95);
        }
    }
}