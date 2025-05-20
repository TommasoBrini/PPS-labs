package ex2

import ex2.Question.{CONFIDENCE, FINAL}
import org.junit.*
import org.junit.Assert.*

class TestConferenceReviewing:

  private val cr = ConferenceReviewing()
  cr.loadReview(1, 8, 8, 6, 8)
  cr.loadReview(1, 9, 9, 6, 9)
  cr.loadReview(2, 9, 9, 10, 9)
  cr.loadReview(2, 4, 6, 10, 6)
  cr.loadReview(3, 3, 3, 3, 3)
  cr.loadReview(3, 4, 4, 4, 4)
  cr.loadReview(4, 6, 6, 6, 6)
  cr.loadReview(4, 7, 7, 8, 7)
  private val map = Map(Question.RELEVANCE -> 8, Question.SIGNIFICANCE -> 8, Question.CONFIDENCE -> 7, Question.FINAL -> 8)
  cr.loadReview(4, map)
  cr.loadReview(5, 6, 6, 6, 10)
  cr.loadReview(5, 7, 7, 7, 10)

  @Test def testOrderedScores(): Unit =
    assertEquals(List(4,9), cr.orderedScores(2, Question.RELEVANCE))
    assertEquals(List(6, 7, 8), cr.orderedScores(4, CONFIDENCE))
    assertEquals(List(10, 10), cr.orderedScores(5, FINAL))

  @Test def testAverageFinalScore(): Unit =
    assertEquals(8.5, cr.averageFinalScore(1), 1)
    assertEquals(7.5, cr.averageFinalScore(2), 1)
    assertEquals(3.5, cr.averageFinalScore(3), 1)
    assertEquals(7.0, cr.averageFinalScore(4), 1)
    assertEquals(10.0, cr.averageFinalScore(5), 1)

  @Test def testAcceptedArticles(): Unit =
    assertEquals(cr.acceptedArticles(), Set(1, 2, 4));

  @Test def testSortedAcceptedArticles(): Unit =
    assertEquals(cr.sortedAcceptedArticles(), List((4, 7.0), (2, 7.5), (1, 8.5)));

  @Test def optionalTestAverageWeightedFinalScore(): Unit =
    assertEquals(cr.averageWeightedFinalScoreMap().getOrElse(1, 0.0),(4.8 + 5.4) / 2, 0.01)
    assertEquals(cr.averageWeightedFinalScoreMap().getOrElse(2, 0.0),(9.0 + 6.0) / 2, 0.01)
    assertEquals(cr.averageWeightedFinalScoreMap().getOrElse(3, 0.0),(0.9 + 1.6) / 2, 0.01)
    assertEquals(cr.averageWeightedFinalScoreMap().getOrElse(4, 0.0),(3.6 + 5.6+5.6) / 3, 0.01)
    assertEquals(cr.averageWeightedFinalScoreMap().getOrElse(5, 0.0),(6.0 + 7.0) / 2, 0.01)
    assertEquals(cr.averageWeightedFinalScoreMap().size, 5)