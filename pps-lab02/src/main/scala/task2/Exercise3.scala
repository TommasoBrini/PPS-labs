package task2

object Exercise3:

  def positive(value: Int): String = value match
    case _ if value >= 0 => "positive"
    case _ => "negative"

