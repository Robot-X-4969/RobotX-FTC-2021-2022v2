package robotx.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robotx.libraries.XOpMode;
import robotx.modules.MecanumDrive;
import robotx.modules.IntakeSystem;
import robotx.modules.ConveyorBelt;
import robotx.modules.LiftSystem;
import robotx.modules.Launcher;

@TeleOp(name = "RobotXOpMode2021", group = "Default")

public class RobotXOpMode2021 extends XOpMode {

    MecanumDrive mecanumDrive;
    IntakeSystem intakeSystem;
    ConveyorBelt conveyorBelt;
    LiftSystem liftSystem;
    Launcher launcher;


    public void initModules() {

        super.initModules();

        mecanumDrive = new MecanumDrive(this);
        activeModules.add(mecanumDrive);

        intakeSystem = new IntakeSystem(this);
        activeModules.add(intakeSystem);

        conveyorBelt = new ConveyorBelt(this);
        activeModules.add(conveyorBelt);

        liftSystem = new LiftSystem(this);
        activeModules.add(liftSystem);

        launcher = new Launcher(this);
        activeModules.add(launcher);


    }

    public void init() {
        super.init();
    }
}