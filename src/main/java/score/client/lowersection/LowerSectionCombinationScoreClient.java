package score.client.lowersection;

import score.assertion.CombinationAssertion;
import score.client.CombinationScoreClient;
import score.model.Hand;

public abstract class LowerSectionCombinationScoreClient
  implements CombinationScoreClient {

  private final CombinationAssertion combinationAssertion;

  public LowerSectionCombinationScoreClient(
    CombinationAssertion combinationAssertion
  ) {
    this.combinationAssertion = combinationAssertion;
  }

  public boolean checkAssertion(Hand hand) {
    return this.combinationAssertion.isChecked(hand);
  }
}
