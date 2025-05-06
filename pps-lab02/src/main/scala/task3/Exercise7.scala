package task3

object Exercise7 extends App:

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)

    println((power(2, 3), power(5, 2)))

  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _p(exp: Int, acc: Double): Double = exp match
      case 0 => acc
      case _ => _p(exp - 1, acc * base)
    _p(exponent, 1)

  println((powerTail(2, 3), powerTail(5, 2)))
