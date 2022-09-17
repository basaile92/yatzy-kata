package score.client.lowersection.fixed;

import score.assertion.straight.LargeStraightAssertion;

public class LargeStraightCombinationScoreAdapter
  extends FixedCombinationScoreClient {

  private static final int LARGE_STRAIGHT_SCORE = 40;

  public LargeStraightCombinationScoreAdapter() {
    super(new LargeStraightAssertion(), LARGE_STRAIGHT_SCORE);
  }
}
