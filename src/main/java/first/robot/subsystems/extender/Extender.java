package first.robot.subsystems.extender;

import org.wpilib.command3.Command;
import org.wpilib.command3.Mechanism;
import org.wpilib.epilogue.Logged;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import first.robot.Schematic;
import first.robot.mechanical.Mechanical;



/** The extender slides the claw in and out on a pulley (the x-axis). */
@Logged
public class Extender implements Mechanism {

  public static final double FULL_EXTEND = +12.0;
  public static final double FULL_RETRACT = -12.0;

  private final SparkMax motor;
  public Extender() {
    this.motor = Mechanical.createSparkMax(Schematic.EXTENDER_SPARK_MAX, MotorType.kBrushless);
  }

  public Command out() {
    return run(coroutine -> {
      while (true) {
        // Add code here to move the extender out.
        motor.setVoltage(FULL_EXTEND);
        coroutine.yield();
         
      }
    }).named("Extender Out");
  }

  public Command in() {
    return run(coroutine -> {
      while (true) {
        // Add code here to move the extender in.
        motor.setVoltage(FULL_RETRACT);
        coroutine.yield();
      }
    }).named("Extender In");
  }

}
