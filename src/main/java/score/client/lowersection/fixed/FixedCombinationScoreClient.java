package score.client.lowersection.fixed;

import score.assertion.CombinationAssertion;
import score.client.lowersection.LowerSectionCombinationScoreClient;
import score.model.Hand;

public abstract class FixedCombinationScoreClient
  extends LowerSectionCombinationScoreClient {

  private final int score;

  protected FixedCombinationScoreClient(
    CombinationAssertion combinationAssertion,
    int score
  ) {
    super(combinationAssertion);
    this.score = score;
  }

  @Override
  public int compute(Hand hand) {
    return fixedScoreIfAssertionIsTrueOrZero(hand);
  }

  private int fixedScoreIfAssertionIsTrueOrZero(Hand hand) {
    if (super.checkAssertion(hand)) return this.score;
    return 0;
  }
}
