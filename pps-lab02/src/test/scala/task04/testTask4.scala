package task4

import org.junit.*
import org.junit.Assert.*
import task4.Exercise9.{Expr, *}
import task4.Exercise9.Expr.*


class testTask4:

  @Test def testEvaluateLiteral(): Unit = {
    val literal = Literal(4)
    assertEquals(4, evaluate(literal))
  }

  @Test def testEvaluateAdd(): Unit = {
    val add = Add(Add(Literal(4), Literal(3)),Literal(3))
    assertEquals(10, evaluate(add))
  }

  @Test def testEvaluateMultiply(): Unit = {
    val multiply = Multiply(Multiply(Literal(2), Literal(5)), Literal(4))
    assertEquals(40, evaluate(multiply))
  }

  @Test def testEvaluateCombined(): Unit = {
    val result = Multiply(Add(Literal(4), Literal(6)), Literal(4))
    assertEquals(40, evaluate(result))
  }

  @Test def testShowLiteral(): Unit = {
    val literal = Literal(5)
    assertEquals("5", show(literal))
  }

  @Test def testShowAdd(): Unit = {
    val add = Add(Add(Literal(4), Literal(3)),Literal(3))
    assertEquals("((4 + 3) + 3)", show(add))
  }

  @Test def testShowMultiply(): Unit = {
    val multiply = Multiply(Multiply(Literal(2), Literal(5)), Literal(4))
    assertEquals("((2 * 5) * 4)", show(multiply))
  }

  @Test def testShowCombined(): Unit = {
    val result = Multiply(Add(Literal(4), Literal(6)), Literal(4))
    assertEquals("((4 + 6) * 4)", show(result))
  }
