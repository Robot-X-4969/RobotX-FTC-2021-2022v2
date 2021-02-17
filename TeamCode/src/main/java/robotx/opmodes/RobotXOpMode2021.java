package robotx.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robotx.libraries.XOpMode;
import robotx.modules.ConveyorBelt;
import robotx.modules.IntakeSystem;
import robotx.modules.Launcher;
import robotx.modules.LiftSystem;
import robotx.modules.OrientationDrive;

@TeleOp(name = "RobotXOpMode2021", group = "Default")

public class RobotXOpMode2021 extends XOpMode {

    OrientationDrive orientationDrive;
    IntakeSystem intakeSystem;
    ConveyorBelt conveyorBelt;
    LiftSystem liftSystem;
    Launcher launcher;


    public void initModules() {

        super.initModules();

        orientationDrive = new OrientationDrive(this);
        activeModules.add(orientationDrive);

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

/*
Controls
GamePad 1:
- Joysticks to drive
- left_bumper: 1/4 speed
- right_bumper: 1/2 speed

GamePad 2:
- a: Lift servo lifts
- b: Lift servo drops
- x: Intake moves inward
- y: Intake moves outward
- dpad_up: Lift goes up
- dpad_down: Lift goes down
- left_bumper: Conveyor pushes towards intake
- right_bumper: Conveyor pushes towards launcher
- dpad_left: Claw servo raises/lowers
- dpad_right: Turns launcher on/off
- left_stick_button: Power shot
-
 */