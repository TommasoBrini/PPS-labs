package u03

import Sequences.*
import Sequence.*

object Task2:

  enum Person:
    case Student(name: String, year: Int)
    case Teacher(name: String, course: String)

  object Person:
    def name(p: Person): String = p match
      case Student(n, _) => n
      case Teacher(n, _) => n

    def course(p: Person): String = p match
      case Teacher(n, c) => c
      case Student(n, y) => "Student!"

    def isStudent(p: Person): Boolean = p match
      case Student(_, _) => true
      case _ => false

  def courses(s: Sequence[Person]): Sequence[String] = s match
    case _ => map(filter(s)(!Person.isStudent(_)))(Person.course)

  def numCoursesTaught(s: Sequence[Person]): Int = s match
    case Cons(h, t) => foldLeft(map(filter(s)(!Person.isStudent(_)))(_ => 1))(0)(_ + _)
    case Nil() => 0