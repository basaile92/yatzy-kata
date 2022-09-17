package score.assertion;

import score.model.Hand;

public class YatzyAssertion implements CombinationAssertion {

  @Override
  public boolean isChecked(Hand hand) {
    return handHasOnlyOneKindOfElement(hand);
  }

  private boolean handHasOnlyOneKindOfElement(Hand hand) {
    return hand.dices().stream().distinct().count() == 1;
  }
}
