package ex2

/**
 * For each article, the reviewer has to reply to all the following questions
 */
enum Question:
  case RELEVANCE, SIGNIFICANCE, CONFIDENCE, FINAL

/**
 * An interface modelling the results of reviewing articles of a conference
 * Each reviewer (revisore) reads an article (articolo), and answers to a number of questions
 * with a score from 0 (bad) to 10 (excellent).
 * Note that each article can be reviewed by many reviewers (typically, from 2 to 4), but the
 * system does not keep track of the identity of reviewers
 *
 */
trait ConferenceReviewing:
  /**
   * loads a review for the specified article, with complete scores as a map
   * @param article: Int
   * @param scores: Map
   */
  def loadReview(article: Int, scores: Map[Question, Int]): Unit

  /**
   * @param article: Int
   * @param relevance: Int
   * @param significance Int
   * @param confidence Int
   * @param fin Int
   * loads a review for the specified article, with the 4 explicit scores
   */
  def loadReview(article: Int, relevance: Int, significance: Int, confidence: Int, fin: Int): Unit

  /**
   * @param article Int
   * @param question Question
   * @return the scores given to the specified article and specified question, as an (ascending-ordered) list
   */
  def orderedScores(article: Int, question: Question): List[Int]

  /**
   * @param article Int
   * @return the average score to question FINAL taken by the specified article
   */
  def averageFinalScore(article: Int): Double
  /**
   * An article is considered accept if its averageFinalScore (not weighted) is > 5,
   * and at least one RELEVANCE score that is >= 8.
   *
   * @return the set of accepted articles
   */
  def acceptedArticles(): Set[Int]
  /**
   * @return accepted articles as a list of pairs article+averageFinalScore, ordered from worst to best based on averageFinalScore
   */
  def sortedAcceptedArticles(): List[(Int, Double)]
  /**
   * @return a map from articles to their average "weighted final score", namely,
   *         the average value of CONFIDENCE*FINAL/10
   *         Note: this method is optional in this exam
   */
  def averageWeightedFinalScoreMap(): Map[Int, Double]

object ConferenceReviewing:
  import Question.*
  def apply(): ConferenceReviewing = ConferenceReviewingImpl()
  case class ConferenceReviewingImpl() extends ConferenceReviewing:
    private var review: List[(Int, Map[Question, Int])] = List()
    override def loadReview(article: Int, scores: Map[Question, Int]): Unit =
      review ::= (article, scores)

    override def loadReview(article: Int, relevance: Int, significance: Int, confidence: Int, fin: Int): Unit =
      review ::= (article, Map(RELEVANCE -> relevance, SIGNIFICANCE -> significance, CONFIDENCE -> confidence, FINAL -> fin))

    override def orderedScores(article: Int, question: Question): List[Int] =
      review.filter(_._1 == article).map(_._2(question)).sorted

    override def averageFinalScore(article: Int): Double =
      val finalVotes = votes(article, Question.FINAL)
      finalVotes.sum.toDouble / finalVotes.size

    private def votes(article: Int, question: Question): List[Int] =
      review.filter(_._1 == article).map(_._2(question))

    override def acceptedArticles(): Set[Int] =
      review.map(_._1).filter(accepted).toSet

    private def accepted(article: Int): Boolean =
      averageFinalScore(article) > 5 && votes(article, Question.RELEVANCE).exists(_ >= 8)

    override def sortedAcceptedArticles(): List[(Int, Double)] =
      acceptedArticles().toList.map(i => (i, averageFinalScore(i))).sortBy(_._2)

    override def averageWeightedFinalScoreMap(): Map[Int, Double] = ???