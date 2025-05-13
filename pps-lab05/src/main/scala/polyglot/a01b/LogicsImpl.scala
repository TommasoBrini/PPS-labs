package polyglot.a01b

import polyglot.OptionToOptional

import java.util.Optional
import util.Optionals.Optional as ScalaOptional
import polyglot.a01b.Logics

import scala.annotation.tailrec
import scala.jdk.javaapi.OptionConverters

trait Logics:
  def hit(x: Int, y: Int): Optional[Integer]
  def won: Boolean

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val minesNumber: Int) extends Logics:
  import util.Sequences.Sequence
  import Sequence.*

  private case class Point(x: Int, y: Int)

  private val mines: Sequence[Point] = generateMines()
  private var safetyCells: Int = 0
  println(mines)


  private def generateMines(): Sequence[Point] =
    val random = java.util.Random()
    @tailrec
    def _mines(counter: Int, acc: Sequence[Point]): Sequence[Point] =
      if counter == minesNumber then acc
      else
        val p = Point(random.nextInt(size - 1), random.nextInt(size - 1))
        if acc.contains(p) then _mines(counter, acc) else _mines(counter + 1, Cons(p, acc))
    _mines(0, Nil())

  override def hit(x: Int, y: Int): Optional[Integer] =
    val p: Point = Point(x, y)
    if mines.contains(p) then OptionToOptional(ScalaOptional.Empty())
    else
      safetyCells = safetyCells + 1
      val adjacent = for
        dx <- -1 to 1
        dy <- -1 to 1
        if !(dx == 0 && dy == 0)
        nx = x + dx
        ny = y + dy
        if nx >= 0 && nx < size && ny >= 0 && ny < size
      yield Point(nx, ny)
      val count = adjacent.count(mines.contains)
      OptionToOptional(ScalaOptional.Just(count))

  override def won =
    safetyCells == (size * size - minesNumber)
