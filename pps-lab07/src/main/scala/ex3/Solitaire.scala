package ex3

object Solitaire extends App:

  type Position = (Int, Int)
  private type Solution = Iterable[Position]
  private type IterableFactory = Solution => Iterable[Solution]
  private val width = 7
  private val height = 5
  given IterableFactory = LazyList(_)

  private def placeMarks(n: Int = width*height)(using factory: IterableFactory): Iterable[Solution] = n match
    case 1 => factory(List((width / 2, height / 2)))
    case _ =>
      for
        positions <- placeMarks(n - 1)
        x <- 0 to width
        y <- 0 to height
        position = (x, y)
        if !positions.toSet.contains(position) && isSafe(position, positions.last)
      yield positions.toSeq :+ position

  private def isSafe(position: Position, from: Position): Boolean =
    allMoves(from) contains position

  def allMoves(initial: Position): List[Position] =
    val moves = List(
      (2, 2), (-2, -2),
      (-2, 2), (2, -2),
      (0, 3), (0, -3),
      (3, 0), (-3, 0)
    )
    for
      (x, y) <- moves
      newX = initial._1 + x
      newY = initial._2 + y
      if newX >= 0 && newX < width && newY >= 0 && newY < height
    yield (newX, newY)

  private def render(solution: Seq[(Int, Int)], width: Int, height: Int): String =
    //val reversed = solution.reverse
    val rows =
      for y <- 0 until height
          row = for x <- 0 until width
          number = solution.indexOf((x, y)) + 1
          yield if number > 0 then "%-2d ".format(number) else "X  "
      yield row.mkString
    rows.mkString("\n")

  private def printSolution(si: (Solution, Int)): Unit =
    println(); println(s"sol ${si._2}")
    println(render(si._1.toSeq, width, height))

  placeMarks().zipWithIndex foreach printSolution