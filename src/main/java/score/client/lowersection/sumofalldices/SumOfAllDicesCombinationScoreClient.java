package score.client.lowersection.sumofalldices;

import score.assertion.CombinationAssertion;
import score.client.lowersection.LowerSectionCombinationScoreClient;
import score.model.Dice;
import score.model.Hand;

public abstract class SumOfAllDicesCombinationScoreClient
  extends LowerSectionCombinationScoreClient {

  public SumOfAllDicesCombinationScoreClient(
    CombinationAssertion combinationAssertion
  ) {
    super(combinationAssertion);
  }

  @Override
  public int compute(Hand hand) {
    return sumOfAllHandDIcesIfAssertionIsTrueOrZero(hand);
  }

  private int sumOfAllHandDIcesIfAssertionIsTrueOrZero(Hand hand) {
    if (super.checkAssertion(hand)) return getSumOfAllHandDices(hand);
    return 0;
  }

  private int getSumOfAllHandDices(Hand hand) {
    return hand
      .dices()
      .stream()
      .map(Dice::value)
      .reduce(Integer::sum)
      .orElse(0);
  }
}
