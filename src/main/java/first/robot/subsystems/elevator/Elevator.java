package first.robot.subsystems.elevator;

import org.wpilib.command3.Command;
import org.wpilib.epilogue.Logged;
import org.wpilib.command3.Mechanism;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import first.robot.Schematic;
import first.robot.mechanical.Mechanical;


@Logged
public class Elevator implements Mechanism {
private final RelativeEncoder encoder;

  public static final double ALL_UP = +12.0;
  public static final double ALL_DOWN = -12.0;

  private final SparkMax motor;
  public Elevator() {
    this.motor = Mechanical.createSparkMax(Schematic.ELEVATOR_SPARK_MAX, MotorType.kBrushless);
    this.encoder = motor.getEncoder();
    setDefaultCommand(hold());
  }
  public Command hold() {
    return run(coroutine -> {
      while (true) {
  
        motor.setVoltage(0);
        coroutine.yield();
        
      }
    }).named("Hold");
  }
  public Command up() {
    return run(coroutine -> {
      while (encoder.getPosition().get() < 1.08) {
  
        motor.setVoltage(ALL_UP);
        coroutine.yield();
         
      }
    }).named("Elevator Up");
  }

  public Command down() {
    return run(coroutine -> {
      while (encoder.getPosition().get() > 0.26) {

        motor.setVoltage(ALL_DOWN);
        coroutine.yield();
      }
    }).named("Elevator Down");
  }
}
