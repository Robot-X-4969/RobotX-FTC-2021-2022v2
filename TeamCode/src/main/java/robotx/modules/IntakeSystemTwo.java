package robotx.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import robotx.libraries.XModule;
import robotx.opmodes.autonomous.RobotXAutonomous2021;

    public class IntakeSystemTwo extends XModule {

        DcMotor intakeMotor;

        Servo adjustServo;

        DcMotor conveyorMotor;

        double power2 = 0.7;


        double power = 0.8;

        boolean adjusted = false;

        public IntakeSystemTwo (RobotXAutonomous2021 op) {
            super(op);
        }

        public void init() {
            intakeMotor = opMode.hardwareMap.dcMotor.get("IntakeMotor");
            adjustServo = opMode.hardwareMap.servo.get("adjustServo");
            conveyorMotor = opMode.hardwareMap.dcMotor.get("ConveyorMotor");
        }

        public void adjustmentServo() {
            if (!adjusted) {

                adjustServo.setPosition(0);
                adjusted = true;
            }
            else {

                adjustServo.setPosition(0.22);
                adjusted = false;
            }
        }

        public void loop() {
            if (xGamepad2().x.isDown()) {
                intakeMotor.setPower(power);
            }

            else if (xGamepad2().y.isDown()) {
                intakeMotor.setPower(-power);
            }

            if (xGamepad1().a.wasPressed()) {
                adjustmentServo();
            }

            else if (xGamepad2().y.isDown()) {
                    conveyorMotor.setPower(-power2);
                }

            else if (xGamepad2().x.isDown()) {
                    conveyorMotor.setPower(power2);
                }

            else {
                    conveyorMotor.setPower(0.0);
                }

        }


    }


