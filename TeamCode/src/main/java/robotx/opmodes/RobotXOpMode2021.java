package robotx.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robotx.libraries.XOpMode;
//import robotx.modules.MecanumDrive;
import robotx.modules.IntakeSystem;
//import robotx.modules.ConveyorBelt;

@TeleOp(name = "RobotXOpMode2021", group = "Default")

public class RobotXOpMode2021 extends XOpMode {

    //MecanumDrive mecanumDrive;
    IntakeSystem intakeSystem;
    //ConveyorBelt conveyorBelt;

    public void initModules() {

        super.initModules();

        //mecanumDrive = new MecanumDrive(this);
        //activeModules.add(mecanumDrive);

        intakeSystem = new IntakeSystem(this);
        activeModules.add(intakeSystem);

        //conveyorBelt = new ConveyorBelt(this);
        //activeModules.add(conveyorBelt);
    }

    public void init() {
        super.init();
    }
}
