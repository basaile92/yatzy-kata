package score.client.lowersection.fixed;

import score.assertion.YatzyAssertion;

public class YatzyCombinationScoreAdapter extends FixedCombinationScoreClient {

  private static final int YATZY_SCORE = 50;

  public YatzyCombinationScoreAdapter() {
    super(new YatzyAssertion(), YATZY_SCORE);
  }
}
