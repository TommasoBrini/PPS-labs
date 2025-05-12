package polyglot.a05b

import polyglot.a05b.Logics
import util.Sequences.Sequence
import util.Sequences.Sequence.*

import scala.annotation.tailrec

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int) extends Logics:

  case class Point(x: Int, y: Int)

  private def randomPoint(): Point =
    val random = scala.util.Random()
    val range = 1 until (size - 1)
    Point(
      x = range(random.nextInt(range.size)),
      y = range(random.nextInt(range.size))
    )

  private val initial: Point = randomPoint()
  private var map: Sequence[Point] = Cons(initial, Nil())
  private var step: Int = 0

  override def tick(): Unit =
    step += 1
    for
      x <- -1 to 1
      y <- -1 to 1
      if x != 0 || y != 0
    do map = Cons(Point(initial.x + x * step, initial.y + y * step), map)

  override def isOver: Boolean =
    map.filter(p => p.x < 0 || p.x == size || p.y < 0 || p.y == size) != Nil()

  override def hasElement(x: Int, y: Int): Boolean =
    map.contains(Point(x, y))
