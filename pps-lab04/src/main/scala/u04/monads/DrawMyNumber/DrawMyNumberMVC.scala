package u04.monads.DrawMyNumber

import u04.monads.DrawMyNumber.States.*
import u04.monads.Monads.*
import Monad.*
import WindowStateImpl.*
import u03.extensionmethods.Streams.*
import u04.monads.DrawMyNumber.Result.*
import DrawMyNumberStateImpl.*

def mv[SM, SV, AM, AV](m1: State[SM, AM], f: AM => State[SV, AV]): State[(SM, SV), AV] =
  State: (sm, sv) =>
    val (sm2, am) = m1.run(sm)
    val (sv2, av) = f(am).run(sv)
    ((sm2, sv2), av)

@main def runDrawMyNumber =

  def windowCreation(topBound: Int, attempts: Int): State[Window, Stream[String]] = for
    _ <- setSize(400, 125)
    _ <- addLabel(text = "You have " + attempts + " attempts. Number is between 0 and " + topBound, name = "Label1")
    _ <- addTextField(name = "GuessField")
    _ <- addButton(text = "guess", name = "GuessButton")
    _ <- show()
    events <- eventStream()
  yield events

  def labelText(res: Any) = {
    res match
      case (Win, attempts) => "You won with " + attempts + " attempts left. Guess to play again"
      case (Loss, number) => "You loss. Number was " + number + ". Guess to play again"
      case (OutOfBound, topBound) => "Number must be between 0 and " + topBound
      case (Less, attempts) => "Number is less than that. Attempts left: " + attempts
      case (More, attempts) => "Number is more than that. Attempts left: " + attempts
  }

  val controller = for
    events <- mv(getTopBoundAndAttempts, windowCreation)
    _ <- seqN(events.map {
      case "GuessButton" => for
        x <- mv(nop(), _ => getText("GuessField"))
        _ <- mv(guess(x.toInt), res => toLabel(labelText(res), "Label1"))
      yield ()
    })
  yield ()

  controller.run((initialState(100, 8), initialWindow))
