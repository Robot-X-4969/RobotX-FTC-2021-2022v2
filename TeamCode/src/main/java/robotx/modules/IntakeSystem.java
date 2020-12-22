package robotx.modules;

import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class IntakeSystem extends XModule {

    DcMotor intakeMotor;

    double power = 0.5;

    public IntakeSystem (OpMode op) {
        super(op);
    }

    public void init() {
        intakeMotor = opMode.hardwareMap.dcMotor.get("IntakeMotor");
    }

    public void loop() {
        if (xGamepad2().x.isDown()) {
            intakeMotor.setPower(-power);
        }

        else if (xGamepad2().y.isDown()) {
            intakeMotor.setPower(power);
        }

        else {
            intakeMotor.setPower(0.0);
        }
    }
}
