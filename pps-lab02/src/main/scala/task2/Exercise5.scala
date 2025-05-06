package task2

object Exercise5 extends App:

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  println(compose(_ - 1, _ * 2)(5))

  def composeGeneric[X, Y, Z](f: Y => Z, g: X => Y): X => Z = x => f(g(x))

  println(composeGeneric[Double, Double, Double](_ - 1.0, _ * 2)(5.0))