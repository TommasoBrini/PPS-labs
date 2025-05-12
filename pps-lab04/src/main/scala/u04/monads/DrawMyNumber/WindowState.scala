package u04.monads.DrawMyNumber

import u04.monads.DrawMyNumber.States.State
import u03.extensionmethods.Streams.*
import u04.monads.Monads.*, Monad.*

trait WindowState:
  type Window
  def initialWindow: Window
  def setSize(width: Int, height: Int): State[Window, Unit]
  def addButton(text: String, name: String): State[Window, Unit]
  def addLabel(text: String, name: String): State[Window, Unit]
  def toLabel(text: String, name: String): State[Window, Unit]
  def addTextField(name: String): State[Window, Unit]
  def show(): State[Window, Unit]
  def exec(cmd: => Unit): State[Window, Unit]
  def eventStream(): State[Window, Stream[String]]

object WindowStateImpl extends WindowState:
  import SwingFunctionalFacade.*

  type Window = Frame

  def initialWindow: Window = createFrame

  def setSize(width: Int, height: Int): State[Window, Unit] =
    State(w => ((w.setSize(width, height)), {}))
  def addButton(text: String, name: String): State[Window, Unit] =
    State(w => (w.addButton(text, name), {}))
  def addLabel(text: String, name: String): State[Window, Unit] =
    State(w => ((w.addLabel(text, name)), {}))
  def toLabel(text: String, name: String): State[Window, Unit] =
    State(w => ((w.showToLabel(text, name)), {}))
  def addTextField(name: String): State[Frame, Unit] =
    State(w => ((w.addTextField(name)), {}))
  def getText(name: String): State[Window, String] =
    State(w => (w, w.getText(name)))
  def show(): State[Window, Unit] =
    State(w => (w.show, {}))
  def exec(cmd: => Unit): State[Window, Unit] =
    State(w => (w, cmd))
  def eventStream(): State[Window, Stream[String]] =
    State(w => (w, Stream.generate(() => w.events().get)))