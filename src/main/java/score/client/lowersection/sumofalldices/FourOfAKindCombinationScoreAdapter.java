package score.client.lowersection.sumofalldices;

import score.assertion.someofakind.FourOfAKindAssertion;

public class FourOfAKindCombinationScoreAdapter
  extends SumOfAllDicesCombinationScoreClient {

  public FourOfAKindCombinationScoreAdapter() {
    super(new FourOfAKindAssertion());
  }
}
