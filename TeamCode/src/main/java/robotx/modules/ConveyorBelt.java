package robotx.modules;
import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;

public class ConveyorBelt extends XModule {
    DcMotor conveyorMotor;

    double power2 = 0.3;

    public ConveyorBelt(OpMode op) {
        super(op);
    }

    public void init() {
        conveyorMotor = opMode.hardwareMap.dcMotor.get("ConveyorMotor");
    }

    public void loop() {
        if (xGamepad2().left_bumper.isDown()) {
            conveyorMotor.setPower(-power2);
        }

        else if (xGamepad2().right_bumper.isDown()) {
            conveyorMotor.setPower(power2);
        }

        else {
            conveyorMotor.setPower(0.0);
        }
    }
}