package polyglot.a01a

import util.Sequences.Sequence
import Sequence.*

trait Logics:
  def hit(row: Int, col: Int): Result

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  case class Point(x: Int, y: Int)

  private val boats: Sequence[Point] = boatPosition()
  private var attempts: Int = 0
  private var hits: Int = 0

  private def boatPosition(): Sequence[Point] =
    val initial: Point = boatInitial()
    println(initial)
    (0 until boat).foldRight(Nil(): Sequence[Point]) { (i, acc) =>
      Cons(Point(initial.x, initial.y + i), acc)
    }

  private def boatInitial(): Point =
    import scala.util.Random
    Point(Random().nextInt(size - 1), Random().nextInt(size - boat))

  def hit(row: Int, col: Int): Result =
    boats.contains(Point(row, col)) match
      case true => hits = hits + 1
        if (hits == boat) then Result.WON else Result.HIT
      case _ => attempts = attempts + 1
        if (attempts == 5) then Result.LOST else Result.MISS
