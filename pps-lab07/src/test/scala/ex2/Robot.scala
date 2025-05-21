package ex2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RobotSpec extends AnyFlatSpec with Matchers:
  "A SimpleRobot" should "turn correctly" in:
    val robot = new SimpleRobot((0, 0), Direction.North)

    robot.turn(Direction.East)
    robot.direction should be(Direction.East)

    robot.turn(Direction.South)
    robot.direction should be(Direction.South)

    robot.turn(Direction.West)
    robot.direction should be(Direction.West)

    robot.turn(Direction.North)
    robot.direction should be(Direction.North)

  it should "act correctly" in:
    val robot = new SimpleRobot((0, 0), Direction.North)

    robot.act()
    robot.position should be((0, 1))

    robot.turn(Direction.East)
    robot.act()
    robot.position should be((1, 1))

    robot.turn(Direction.South)
    robot.act()
    robot.position should be((1, 0))

    robot.turn(Direction.West)
    robot.act()
    robot.position should be((0, 0))

  "A RobotWithBattery" should "turn correctly" in:
    val robot: Robot = new RobotWithBattery(new SimpleRobot((0, 0), Direction.North), 1, 10)
    for
      _ <- 1 to 10
    do
      robot.turn(Direction.East)
      robot.direction should be(Direction.East)
    robot.turn(Direction.North)
    robot.direction should be(Direction.East)

  it should "act correctly" in:
    val robot: Robot = new RobotWithBattery(new SimpleRobot((0, 0), Direction.North), 1, 10)
    for
      x <- 1 to 10
    do
      robot.act()
      robot.position should be((0, x))
    robot.position should be((0, 10))
    robot.act()
    robot.position should be((0, 10))

  "A RobotCanFail" should "turn correctly" in:
    val failedRobot: Robot = new RobotCanFail(new SimpleRobot((0,0), Direction.North), 100)
    failedRobot.turn(Direction.East)
    failedRobot.direction should be(Direction.North)

    val successfulRobot: Robot = new RobotCanFail(new SimpleRobot((0,0), Direction.North), 0)
    successfulRobot.turn(Direction.East)
    successfulRobot.direction should be(Direction.East)

  it should "act correctly" in:
    val failedRobot: Robot = new RobotCanFail(new SimpleRobot((0,0), Direction.North), 100)
    failedRobot.act()
    failedRobot.position should be((0,0))

    val successfulRobot: Robot = new RobotCanFail(new SimpleRobot((0,0), Direction.North), 0)
    successfulRobot.act()
    successfulRobot.position should be((0,1))

  "A RobotRepeated" should "turn correctly" in:
    val robot: Robot = new RobotRepeated(new SimpleRobot((0,0), Direction.North), 3)
    robot.turn(Direction.East)
    robot.direction should be(Direction.East)

  it should "act correctly" in:
    val robot: Robot = new RobotRepeated(new SimpleRobot((0,0), Direction.North), 3)
    robot.act()
    robot.position should be((0,3))
