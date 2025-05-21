package ex3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolitaireTest extends AnyFlatSpec with Matchers:
    import Solitaire.allMoves

/*
    "All moves" should "give correct moves" in:
      allMoves((2,2)).toSet should be(Set((0,0), (4,4), (0,4), (4,0)))
*/