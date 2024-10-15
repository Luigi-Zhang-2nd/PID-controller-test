package frc.robot;


import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkMax;

public class Height {
    CANSparkMax Height_Motor = new CANSparkMax(Constants.Height_Motor_CAN_ID, MotorType.kBrushless);
    SparkAbsoluteEncoder Height_Pos = Height_Motor.getAbsoluteEncoder();
    SparkPIDController PIDController = Height_Motor.getPIDController();

    public void Height_Set_speed(double speed){
        Height_Motor.set(speed);
    }
    
    public void Height_Motor_Stop(){
        Height_Motor.stopMotor();
    }

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
        PIDController.setOutputRange(-0.05, 0.05);
        PIDController.setReference(pos, CANSparkMax.ControlType.kPosition);

    }
}
