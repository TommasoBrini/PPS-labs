package task1

object Exercise2 extends App:

  def divide(x: Double, y: Double): Double = x / y

  println(divide(3, 6))
  println(divide(6,3))

  private def divideCurried(y: Double)(x: Double) = x / y

  private val divideBy3 = divideCurried(3)
  println(divideBy3(6))
