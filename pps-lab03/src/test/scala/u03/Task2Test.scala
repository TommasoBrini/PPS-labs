package u03

import org.junit.*
import org.junit.Assert.*
import u03.Task2.*
import Person.*
import Sequences.*
import Sequence.*

class Task2Test:

  val teacher1: Person = Person.Teacher("Viroli", "pps")
  val teacher2: Person = Person.Teacher("Aguzzi", "pcd")
  val student: Person = Person.Student("Tommaso", 2025)

  @Test def testCourses(): Unit =
    assertEquals(Cons("pps", Cons("pcd", Nil())), courses(Cons(teacher1, Cons(student, Cons(teacher2, Nil())))))

  @Test def testNumCoursesTaught(): Unit =
    assertEquals(2, numCoursesTaught(Cons(teacher1, Cons(student, Cons(teacher2, Nil())))))
