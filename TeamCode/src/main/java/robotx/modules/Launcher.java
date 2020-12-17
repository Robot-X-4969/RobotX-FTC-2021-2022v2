package robotx.modules;
import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Launcher extends XModule {

    DcMotor launcherMotor;

    double launcherPower = 0.7;
    double powerShotPower = 0.5;

    public Launcher(OpMode op) {
        super(op);
    }

    public void init() {
        launcherMotor = opMode.hardwareMap.dcMotor.get("LauncherMotor");
    }

    public void loop() {
        if (xGamepad2().dpad_right.isDown()) {
            launcherMotor.setPower(launcherPower);
        }

        else if (xGamepad2().left_stick_button.isDown()) {
            launcherMotor.setPower(powerShotPower);
        }

        else {
            launcherMotor.setPower(0.0);
        }
    }
}