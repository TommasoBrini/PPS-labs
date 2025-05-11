package u04.monads

import States.*
import Optionals.Optional

def mv[SM, SV, AM, AV](m1: State[SM,AM], f: AM => State[SV,AV]): State[(SM,SV), AV] =
  State: (sm, sv) =>
    val (sm2, am) = m1.run(sm)
    val (sv2, av) = f(am).run(sv)
    ((sm2, sv2), av)

@main def runMVC =
  import Monads.*, Monad.*, CounterStateImpl.*, WindowStateImpl.*
  import u03.extensionmethods.Streams.*

  def windowCreation(str: String): State[Window, Stream[String]] = for 
    _ <- setSize(300, 300)
    _ <- addButton(text = "inc", name = "IncButton")
    _ <- addButton(text = "dec", name = "DecButton")
    _ <- addButton(text = "reset", name = "ResetButton")
    _ <- addButton(text = "quit", name = "QuitButton")
    _ <- addLabel(text = str, name = "Label1")
    _ <- addTextField(name = "TextField1")
    _ <- addButton(text = "set", name = "SetButton")
    _ <- show()
    events <- eventStream()
  yield events

  def checkedParse(s: String): Optional[Int] = {
    try
      val number = s.toInt
      Optional.Just(number)
    catch
      case _: NumberFormatException => println("Non valid number"); Optional.Empty()
  }

  val controller = for
    events <- mv(get(), i => windowCreation(i.toString))
    _ <- seqN(events.map{
        case "IncButton" => mv(seq(inc(), get()), i => toLabel(i.toString, "Label1"))
        case "DecButton" => mv(seq(dec(), get()), i => toLabel(i.toString, "Label1"))
        case "ResetButton" => mv(seq(reset(), get()), i => toLabel(i.toString, "Label1"))
        case "QuitButton" => mv(nop(), _ => exec(sys.exit()))
        case "SetButton" => for
          s <- mv(nop(), _ => getText("TextField1"))
          _ <- mv(seq(set(checkedParse(s).orElse(0)), get()), i => toLabel(i.toString, "Label1"))
        yield ()
    })
  yield ()

  controller.run((initialCounter(), initialWindow))