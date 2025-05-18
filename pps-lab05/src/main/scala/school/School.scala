package school

import util.Sequences.Sequence
import Sequence.*

trait Teacher:
  def name: String

object Teacher:
  def apply(name: String): Teacher = TeacherImpl(name)
  private case class TeacherImpl(name: String) extends Teacher

trait Course:
  def name: String

object Course:
  def apply(name: String): Course = CourseImpl(name)
  private case class CourseImpl(name: String) extends Course

trait School:
  def teachers: Sequence[String]
  def courses: Sequence[String]
  def setTeacherToCourse(teacher: Teacher, course: Course): School
  def coursesOfATeacher(teacher: Teacher): Sequence[Course]
  def hasTeacher(name: String): Boolean
  def hasCourse(name: String): Boolean

object School:
  def apply(school: Sequence[(Teacher, Course)]): School = SchoolImpl(school)
  def emptySchool: School = apply(Nil())
  def teacher(name: String): Teacher = Teacher(name)
  def course(name: String): Course = Course(name)
  private class SchoolImpl(school: Sequence[(Teacher, Course)]) extends School:

    override def teachers: Sequence[String] = school.map((t, _) => t.name).distinct()

    override def courses: Sequence[String] = school.map((_, c) => c.name).distinct()

    override def setTeacherToCourse(teacher: Teacher, course: Course): School =
      if !(school.contains((teacher, course))) then apply(Cons((teacher, course), school)) else apply(school)

    override def coursesOfATeacher(teacher: Teacher): Sequence[Course] =
      school.filter((t, _) => t == teacher).map((_, c) => c)

    override def hasTeacher(name: String): Boolean =
      teachers.contains(name)

    override def hasCourse(name: String): Boolean =
      courses.contains(name)

