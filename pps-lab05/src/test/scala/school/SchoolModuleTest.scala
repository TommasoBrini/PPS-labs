package school

import org.junit.*
import org.junit.Assert.*
import school.School.*
import util.Sequences.Sequence.*

class SchoolModuleTest:

  @Test def testTeacherName() =
    assertEquals("Mario", Teacher("Mario").name)

  @Test def testCourseName() =
    assertEquals("Math", Course("Math", "Science").name)

  @Test def testEmptySchool() =
    assertEquals(Nil(), emptySchool.teachers())
    assertEquals(Nil(), emptySchool.courses())

  @Test def testSetTeacherToCourse() = {
    val newSchool = emptySchool.setTeacherToCourse(Teacher("Mario"), Course("Math", "Science"))
    assertEquals(Cons("Mario", Nil()), newSchool.teachers())
    assertEquals(Cons("Math", Nil()), newSchool.courses())
    assertTrue(newSchool.hasTeacher("Mario"))
    assertTrue(newSchool.hasCourse("Math"))
    assertEquals(Cons(Course("Math", "Science"), Nil()), newSchool.coursesOfATeacher(Teacher("Mario")))
  }
