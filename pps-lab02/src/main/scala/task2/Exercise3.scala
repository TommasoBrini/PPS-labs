package task2

object Exercise3 extends App:

  // PART A

  // i
  private val positiveVal: Int => String = _ match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println(positiveVal(-5))

  // ii
  private def positive(value: Int): String = value match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println(positive(5))

  // part b
  private val negVal: (String => Boolean) => String => Boolean = predicate => s => !predicate(s)
  private def neg(predicate: String => Boolean): String => Boolean = s => !predicate(s)

  val empty: String => Boolean = _ == ""
  private val notEmpty: String => Boolean = negVal(empty)
  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))

  // PART C
  private def negGeneric[X](predicate: X => Boolean): X => Boolean = x => !predicate(x)

  private val isZero: Int => Boolean = _ == 0
  private val notZero: Int => Boolean = negGeneric(isZero)
  private val notEmptyGeneric = negGeneric(empty)

  println(notZero(1)) // true
  println(notZero(0)) // false
  println(notEmptyGeneric("")) // false
  println(notEmptyGeneric("foo")) // true




