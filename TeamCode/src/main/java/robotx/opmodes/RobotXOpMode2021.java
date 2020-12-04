package robotx.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robotx.libraries.XOpMode;
import robotx.modules.MecanumDrive;
import robotx.modules.IntakeSystem;

@TeleOp(name = "RobotXOpMode2021", group = "Default")

public class RobotXOpMode2021 extends XOpMode {

    MecanumDrive mecanumDrive;
    IntakeSystem intakeSystem;

    public void initModules() {

        super.initModules();

        mecanumDrive = new MecanumDrive(this);
        activeModules.add(mecanumDrive);

        intakeSystem = new IntakeSystem(this);
        activeModules.add(intakeSystem);

    }

    public void init() {
        super.init();
    }
}
