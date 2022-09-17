package score.client.lowersection.sumofalldices;

import score.assertion.someofakind.ThreeOfAKindAssertion;

public class ThreeOfAKindCombinationScoreAdapter
  extends SumOfAllDicesCombinationScoreClient {

  public ThreeOfAKindCombinationScoreAdapter() {
    super(new ThreeOfAKindAssertion());
  }
}
