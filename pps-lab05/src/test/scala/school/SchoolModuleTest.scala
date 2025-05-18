package school

import util.Sequences.*
import Sequence.*
import org.junit.*
import org.junit.Assert.*
import school.School.*

class SchoolTest:

  @Test def testTeacher(): Unit =
    assertEquals("Viroli", teacher("Viroli").name)

  @Test def testCourse(): Unit =
    assertEquals("PPS", course("PPS").name)

  @Test def testTeacherAndCourseAfterEmptySchool(): Unit =
    val school = emptySchool
    assertEquals(Nil(), school.teachers)
    assertEquals(Nil(), school.courses)

  @Test def testCourses(): Unit =
    val school = emptySchool
    val school2 = school.setTeacherToCourse(teacher("Viroli"), course("PPS"))
    val school3 = school2.setTeacherToCourse(teacher("Viroli"), course("PPS"))
    assertEquals(Cons("PPS", Nil()), school3.courses)

  @Test def testTeachers(): Unit =
    val school = emptySchool
    val school2 = school.setTeacherToCourse(teacher("Viroli"), course("PPS"))
    val school3 = school2.setTeacherToCourse(teacher("Viroli"), course("OOP"))
    assertEquals(Cons("Viroli", Nil()), school3.teachers)

  @Test def testSetTeacherToCourses(): Unit =
    val school = emptySchool
    val school2 = school.setTeacherToCourse(teacher("Viroli"), course("PPS"))
    assertEquals(Cons("Viroli", Nil()), school2.teachers)
    assertEquals(Cons("PPS", Nil()), school2.courses)

  @Test def testCoursesOfATeacherInEmptySchool(): Unit =
    val empty = emptySchool
    assertEquals(Nil(), empty.coursesOfATeacher(teacher("John")))

  @Test def testCoursesOfATeacher(): Unit =
    val school = emptySchool.setTeacherToCourse(teacher("John"), course("Math"))
    val school2 = school.setTeacherToCourse(teacher("John"), course("Math"))
    val school3 = school2.setTeacherToCourse(teacher("John"), course("Italian"))
    assertEquals(Cons(Course("Math"), Nil()), school.coursesOfATeacher(teacher("John")))
    assertEquals(Cons(Course("Italian"), Cons(Course("Math"), Nil())), school3.coursesOfATeacher(teacher("John")))

  @Test def testHasTeacher(): Unit =
    assertFalse(emptySchool.hasTeacher("John"))
    assertTrue(emptySchool.setTeacherToCourse(teacher("John"), course("Math")).hasTeacher("John"))

  @Test def testHasCourse(): Unit =
    assertFalse(emptySchool.hasCourse("Math"))
    assertTrue(emptySchool.setTeacherToCourse(teacher("John"), course("Math")).hasCourse("Math"))

