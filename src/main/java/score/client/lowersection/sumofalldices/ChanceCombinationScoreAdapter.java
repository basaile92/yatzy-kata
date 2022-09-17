package score.client.lowersection.sumofalldices;

import score.assertion.ChanceAssertion;

public class ChanceCombinationScoreAdapter
  extends SumOfAllDicesCombinationScoreClient {

  public ChanceCombinationScoreAdapter() {
    super(new ChanceAssertion());
  }
}
