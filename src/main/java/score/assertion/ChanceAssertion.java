package score.assertion;

import score.model.Hand;

public class ChanceAssertion implements CombinationAssertion {

  @Override
  public boolean isChecked(Hand hand) {
    return true;
  }
}
