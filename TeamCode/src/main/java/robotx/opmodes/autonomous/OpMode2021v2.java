package robotx.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robotx.libraries.XOpMode;
import robotx.modules.ConveyorBelt;
import robotx.modules.IntakeSystem;
import robotx.modules.Launcher;
import robotx.modules.LiftSystem;
import robotx.modules.OrientationDrive;
import robotx.modules.IntakeSystem2;
import robotx.modules.LauncherV2;
import robotx.modules.LiftSystem2;

@TeleOp(name = "OpMode2021v2", group = "Default")

public class OpMode2021v2 extends XOpMode {

    OrientationDrive orientationDrive;
    IntakeSystem2 intakeSystem2;
    LauncherV2 launcherV2;
    LiftSystem2 liftSystem2;

    public void initModules() {

        super.initModules();

        orientationDrive = new OrientationDrive(this);
        activeModules.add(orientationDrive);

        intakeSystem2 = new IntakeSystem2(this);
        activeModules.add(intakeSystem2);

        launcherV2 = new LauncherV2(this);
        activeModules.add(launcherV2);

        liftSystem2 = new LiftSystem2(this);
        activeModules.add(liftSystem2);
    }

    public void init() {
        super.init();
    }
}

/*
Controls
GamePad 1:
Joysticks to move
B to reset robot orientation
Left bumper to toggle slow mode
Right bumper to toggle super slow mode

GamePad 2:
Dpad_left to use block servo (toggle)
Dpad_right to use launcher
Left bumper to move conveyor backward
Right bumper to move conveyor forward
A to open claw
B to close claw
Dpad_up to use arm motor
X to move intake forward
Y to move intake backward
Right_stick_button to use adjustment servo
}*/