package robotx.modules;
import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Launcher extends XModule {

    DcMotor launcherMotor;

    Servo launcherServo;

    double launcherPower = 1.0;
    double powerShotPower = 0.9;

    boolean launcherOn = false;

    public Launcher(OpMode op) {
        super(op);
    }

    public void init() {

        launcherMotor = opMode.hardwareMap.dcMotor.get("LauncherMotor");

        launcherServo = opMode.hardwareMap.servo.get("LauncherServo");
    }

    public void launcherMotor() {
        if (launcherOn == false) {
            launcherMotor.setPower(launcherPower);
            launcherOn = true;
        }

        else {
            launcherMotor.setPower(0.0);
            launcherOn = false;
        }
    }

    public void loop() {

        if (xGamepad2().dpad_right.wasPressed()) {
            launcherMotor();
        }

        else if (xGamepad2().left_stick_button.isDown()) {
            launcherMotor.setPower(powerShotPower);
        }

        else {
            launcherMotor.setPower(0.0);
        }

        if (xGamepad2().right_stick_button.isDown()) {
            launcherServo.setPosition(0.735);
        }

        else {
            launcherServo.setPosition(0.95);
        }
    }
}