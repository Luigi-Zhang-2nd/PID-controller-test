package frc.robot;


import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkMax;
/**
 * The class is for the rotational angle of a motor (for the shooter)
 */
public class Height  {
    CANSparkMax Height_Motor;
    /**
     * Takes the Can_ID value to create a brushless spark max controller object
     * @param CAN_ID
     */
    public Height(int CAN_ID){
        Height_Motor = new CANSparkMax(CAN_ID, MotorType.kBrushless);
    }
    SparkAbsoluteEncoder Height_Pos = Height_Motor.getAbsoluteEncoder();
    SparkPIDController PIDController = Height_Motor.getPIDController();
    /**
     * set the speed of the height motor
     * @param speed
     */
    public void Height_Set_speed(double speed){
        Height_Motor.set(speed);
    }
    public void Height_Motor_Stop(){
        Height_Motor.stopMotor();
    }
    /**
     * dont seem to work, but would be nice if it can set the 0 offset of the encoder
     */
    public void Pos_Init(){
        Height_Pos.setZeroOffset(0);
    }
    /**
     * Goes to the set position in the encoder and sustain motor at that level
     * @param pos
     */
    public void go_to(double pos){
        //set PIDcontroller Coefficients (Copied from GitHub)
        PIDController.setP(0.1);
        PIDController.setI(1e-4);
        PIDController.setD(1);
        PIDController.setFF(0);
        PIDController.setOutputRange(-0.06, 0.06);
        PIDController.setReference(pos, CANSparkMax.ControlType.kPosition);

    }
}
