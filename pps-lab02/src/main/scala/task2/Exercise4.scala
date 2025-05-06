package task2

object Exercise4 extends App:

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z

  val p2: (Int, Int, Int) => Boolean = (x,y,z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int) = x <= y && y == z

  def p4(x: Int, y: Int, z: Int) = x <= y && y == z

  println(p1(3)(4)(4))
  println(p2(3, 4, 4))
  println(p3(3)(4)(4))
  println(p4(3, 4, 4))
