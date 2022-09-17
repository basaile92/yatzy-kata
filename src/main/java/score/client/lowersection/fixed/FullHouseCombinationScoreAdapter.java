package score.client.lowersection.fixed;

import score.assertion.FullHouseAssertion;

public class FullHouseCombinationScoreAdapter
  extends FixedCombinationScoreClient {

  private static final int FULL_HOUSE_SCORE = 25;

  public FullHouseCombinationScoreAdapter() {
    super(new FullHouseAssertion(), FULL_HOUSE_SCORE);
  }
}
