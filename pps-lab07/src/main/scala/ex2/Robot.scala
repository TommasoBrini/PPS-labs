package ex2

type Position = (Int, Int)
enum Direction:
  case North, East, South, West
  def turnRight: Direction = this match
    case Direction.North => Direction.East
    case Direction.East => Direction.South
    case Direction.South => Direction.West
    case Direction.West => Direction.North

  def turnLeft: Direction = this match
    case Direction.North => Direction.West
    case Direction.West => Direction.South
    case Direction.South => Direction.East
    case Direction.East => Direction.North

trait Robot:
  def position: Position
  def direction: Direction
  def turn(dir: Direction): Unit
  def act(): Unit

class SimpleRobot(var position: Position, var direction: Direction) extends Robot:
  def turn(dir: Direction): Unit = direction = dir
  def act(): Unit = position = direction match
    case Direction.North => (position._1, position._2 + 1)
    case Direction.East => (position._1 + 1, position._2)
    case Direction.South => (position._1, position._2 - 1)
    case Direction.West => (position._1 - 1, position._2)

  override def toString: String = s"robot at $position facing $direction"

class DumbRobot(val robot: Robot) extends Robot:
  export robot.{position, direction, act}
  override def turn(dir: Direction): Unit = {}
  override def toString: String = s"${robot.toString} (Dump)"

class LoggingRobot(val robot: Robot) extends Robot:
  export robot.{position, direction, turn}
  override def act(): Unit =
    robot.act()
    println(robot.toString)

class RobotWithBattery(val robot: Robot, val cost: Int, var battery: Int) extends Robot:
  export robot.{position, direction}
  private def charge: Boolean =
    battery > 0
  private def consume(): Unit =
    battery -= cost
  override def turn(dir: Direction): Unit =
    if charge then
      robot.turn(dir)
      consume()
  override def act(): Unit =
    if charge then
      robot.act()
      consume()

class RobotCanFail(val robot: Robot, val failProbability: Int) extends Robot:
  export robot.{position, direction}
  import scala.util.Random
  private val random = Random(1234)
  private def success: Boolean =
    random.nextDouble() * 100 > failProbability

  override def turn(dir: Direction): Unit =
    if success then
      robot.turn(dir)

  override def act(): Unit =
    if success then
      robot.act()

class RobotRepeated(robot: Robot, repetition: Int) extends Robot:
  export robot.{position, direction}

  override def turn(dir: Direction): Unit =
    for
      _ <- 1 to repetition
    do robot.turn(dir)

  override def act(): Unit =
    for
      _ <- 1 to repetition
    do robot.act()

@main def testRobot(): Unit =
  val robot = LoggingRobot(SimpleRobot((0, 0), Direction.North))
  robot.act() // robot at (0, 1) facing North
  robot.turn(robot.direction.turnRight) // robot at (0, 1) facing East
  robot.act() // robot at (1, 1) facing East
  robot.act() // robot at (2, 1) facing East
