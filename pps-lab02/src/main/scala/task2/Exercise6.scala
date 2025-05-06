package task2

object Exercise6 extends App:

  def composeThree[A,B,C,D](f: C =>D, g: B => C, h: A => B): A => D = x => f(g(h(x)))

  println(composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3))