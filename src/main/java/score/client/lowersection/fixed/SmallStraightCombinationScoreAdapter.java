package score.client.lowersection.fixed;

import score.assertion.straight.SmallStraightAssertion;

public class SmallStraightCombinationScoreAdapter
  extends FixedCombinationScoreClient {

  private static final int SMALL_STRAIGHT_SCORE = 30;

  public SmallStraightCombinationScoreAdapter() {
    super(new SmallStraightAssertion(), SMALL_STRAIGHT_SCORE);
  }
}
