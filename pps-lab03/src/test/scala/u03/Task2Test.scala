package u03

import org.junit.*
import org.junit.Assert.*
import u03.Task2.*
import Person.*
import Sequences.*
import Sequence.*

class Task2Test:

  @Test def testCourses(): Unit =
    val teacher1 = Person.Teacher("Viroli", "pps")
    val teacher2 = Person.Teacher("Aguzzi", "pcd")
    val student = Person.Student("Tommaso", 2025)
    assertEquals(Cons("pps", Cons("pcd", Nil())),
      courses(Cons(teacher1, Cons(student, Cons(teacher2, Nil())))))

  @Test def testNumCoursesTaugh(): Unit =
    val teacher1 = Person.Teacher("Mirko", "pps")
    val teacher2 = Person.Teacher("Alessandro", "pcd")
    val student1 = Person.Student("Ettore", 2025)
    val student2 = Person.Student("Ettore", 2025)
    assertEquals(numCoursesTaught(Cons(teacher1, Cons(student1, Cons(student2, Cons(teacher2, Nil()))))), 2)
