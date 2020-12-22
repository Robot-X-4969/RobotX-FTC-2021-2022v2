package robotx.modules;

import robotx.libraries.XModule;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class NewDriveSystem extends XModule {

    public DcMotor fLeft;
    public DcMotor fRight;
    public DcMotor bLeft;
    public DcMotor bRight;

    public NewDriveSystem(OpMode op) {super(op);}

    public void init() {
        fLeft = opMode.hardwareMap.dcMotor.get("fLeft");
        fRight = opMode.hardwareMap.dcMotor.get("fRight");
        bLeft = opMode.hardwareMap.dcMotor.get("bLeft");
        bRight = opMode.hardwareMap.dcMotor.get("bRight");
    }

    public void loop() {double xPow = -1 * controlRamp( xGamepad1().left_stick_x); // Negate the left stick value because negative is right. Negating it will make negative left, as we want
        double yPow = controlRamp(xGamepad1().left_stick_y);
        double rotPow = -1 *  controlRamp(xGamepad1().right_stick_x); //again, negate because negative is right

        /* note
            For mechanum drive to strafe to the right, the wheels on the right turn outwards // wheels on left turn inwards
            For mechanum drive to strafe to left, the wheels on left turn outwards // wheels on right turn inwards
        */

        // another note: positive y value is the FORWARDS direction for all wheels, not "clockwise" or "counterclockwise"; reversed earlier

        double flPow = yPow - xPow + rotPow;

        //+ yPow -> if the control stick is held in the up direction, move this wheel forwards
        //note: can just keep using yPow for forwards for all four wheels even when they spin in opposite directions to move forward; reversed some motors earlier
        //- xPow -> if pressing stick to the right (positive value), want this to spin backwards
        //+ rotPow -> if want to rotate to right (positive value), want this to spin forwards

        double frPow = yPow + xPow - rotPow;

        //+ yPow -> if control stick is up, want to move forwards
        //+ xPow -> if control stick is right (positive value), want to spin forwards
        //- rotPow -> if control stick is right (positive value), want to spin backwards



        //double blPow = .75 * (yPow + xPow + rotPow);
        double blPow = yPow + xPow + rotPow;

        //+ yPow -> if control stick is up, want to move forwards
        //+ xPow -> if control stick is right (positive value), want to spin forwards
        //+ rotPow -> if control stick is right (positive value), want to spin forwards

        //double brPow = .75 * (yPow - xPow - rotPow);
        double brPow = yPow - xPow - rotPow;

        //+ yPow -> if control stick is up, want to move forwards
        //- xPow -> if control stick is right (positive value), want to spin backwards
        //- rotPow -> if control stick is right (positive value), want to spin backwards
        if ( 0 < Math.abs(flPow) && Math.abs(flPow) < 0.5){
            fLeft.setPower(0);
            fRight.setPower(0);
            bLeft.setPower(0);
            bRight.setPower(0);
        }
        else if ( 0 < Math.abs(frPow) && Math.abs(frPow) < 0.5){
            fLeft.setPower(0);
            fRight.setPower(0);
            bLeft.setPower(0);
            bRight.setPower(0);
        }
        else if ( 0 < Math.abs(brPow) && Math.abs(brPow) < 0.5){
            fLeft.setPower(0);
            fRight.setPower(0);
            bLeft.setPower(0);
            bRight.setPower(0);
        }
        else if ( 0 < Math.abs(blPow) && Math.abs(blPow) < 0.5){
            fLeft.setPower(0);
            fRight.setPower(0);
            bLeft.setPower(0);
            bRight.setPower(0);
        }
        else{
            fLeft.setPower(flPow);
            fRight.setPower(frPow);
            bLeft.setPower(blPow);
            bRight.setPower(brPow);
        }
    }

    public double controlRamp(double input) {

        double output = input;
        double coeff = 1.0;
        if (xGamepad1().right_bumper.isDown())
        {
            coeff = coeff / 2.0;
        }

        else if (xGamepad1().left_bumper.isDown())
        {
            coeff = coeff / 4.0;
        }

        else
        {
            coeff = coeff ;
        }

        return output * coeff;
    }

}