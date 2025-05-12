package exercise

import u04.monads.Monads.*

/* Implementa una monade Reader,
  che rappresenta una computazione che legge da un ambiente immutabile
  (es. configurazione o contesto).
 */

object ReaderMonad:

  case class Reader[R, A](run: R => A)

  given [R]: Monad[[X] =>> Reader[R, X]] with
    override def unit[A](a: A): Reader[R, A] = Reader(_ => a)

    extension [A](r: Reader[R, A])
      override def flatMap[B](f: A => Reader[R, B]): Reader[R, B] =
        Reader(env => f(r.run(env)).run(env))

@main def main: Unit =
  import ReaderMonad.*

  type Config = Map[String, String]

  val getUser: Reader[Config, String] =
    Reader(env => env.getOrElse("user", "defaultUser"))

  val getGreeting: Reader[Config, String] = for
    user <- getUser
  yield s"Hello, $user!"

  val config1 = Map("user" -> "Alice")
  val config2 = Map.empty[String, String]

  println(getGreeting.run(config1)) // Hello, Alice!
  println(getGreeting.run(config2)) // Hello, defaultUser!

  // Test semplificato
  assert(getGreeting.run(config1) == "Hello, Alice!")
  assert(getGreeting.run(config2) == "Hello, defaultUser!")
