package robotx.modules;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import robotx.libraries.XModule;

public class GyroDrive extends XModule {
    public GyroDrive(OpMode op) {
        super(op);
    }

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor backLeft;
    public BNO055IMU gyroSensor;
    public Orientation lastAngles = new Orientation();
    public double globalAngle;
    public double robotAngle;
    public double joystickAngle;

    public double x;
    public double y;
    public double s;
    public double r;

    public double xPrime;
    public double yPrime;

    public boolean orientationMode = true;
    public double offset = 0;

    public boolean slowMode = false;
    public boolean superSlowMode = false;

    double flPow = ((yPrime - xPrime - r) * (s));
    double frPow = ((yPrime + xPrime + r) * (s));
    double brPow = ((yPrime - xPrime + r) * (s));
    double blPow = ((yPrime + xPrime - r) * (s));

    public void init() {
        frontLeft = opMode.hardwareMap.dcMotor.get("frontLeft");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight = opMode.hardwareMap.dcMotor.get("frontRight");
        //frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight = opMode.hardwareMap.dcMotor.get("backRight");
        //backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft = opMode.hardwareMap.dcMotor.get("backLeft");
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        gyroSensor = opMode.hardwareMap.get(BNO055IMU.class, "gyroSensor");
        gyroSensor.initialize(parameters);
    }
}