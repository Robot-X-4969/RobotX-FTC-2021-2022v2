package robotx.modules;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import robotx.libraries.XModule;

public class LauncherV2 extends XModule {

    public DcMotor launcherMotor;
    public DcMotor conveyorMotor;

    public double power = 1.0;
    public double conveyorPower = 1.0;

    public LauncherV2(OpMode op) {
        super(op);
    }

    public void init() {

        launcherMotor = opMode.hardwareMap.dcMotor.get("LauncherMotor");
        conveyorMotor = opMode.hardwareMap.dcMotor.get("ConveyorMotor");
    }

    public void loop() {
        if (xGamepad2().dpad_right.isDown()) {
            launcherMotor.setPower(-power);
        }
        else {
            launcherMotor.setPower(0.0);
        }

        if (xGamepad2().y.isDown()) {
            conveyorMotor.setPower(-conveyorPower);
        }
        else if (xGamepad2().x.isDown()) {
            conveyorMotor.setPower(conveyorPower);
        }
        else {
            conveyorMotor.setPower(0.0);
        }
    }
}