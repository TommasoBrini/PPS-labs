package task3

import scala.annotation.tailrec

object Exercise8 extends App:

  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ => _reverse(n/10, (acc * 10) + n % 10)
    _reverse(n, 0)

  println(reverseNumber(1234))



