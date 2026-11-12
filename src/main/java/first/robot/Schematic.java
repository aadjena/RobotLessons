package first.robot;

/** Electrical schematic constants (CAN IDs and hardware port assignments) for the robot. */
public final class Schematic {
  private Schematic() {}

  // ---- USB Ports ----
  public static final int DRIVER_CONTROLLER_PORT = 1;
  public static final int OPERATOR_CONTROLLER_PORT = 2;

  // ---- Motor Controller CAN IDs ----
  public static final int DRIVE_CAN_ID = 1;
  public static final int ELEVATOR_SPARK_MAX = 2;
  public static final int CLAW_SPARK_MAX = 4;
  public static final int KICKER_SPARK_MAX = 5;
  public static final int EXTENDER_SPARK_MAX = 3;

  // ---- Digital I/O ----
  public static final int CLAW_BALL_SENSOR = 1;
  public static final int KICKER_SOLENOID = 2;
  public static final int LEDS = 5;
}
