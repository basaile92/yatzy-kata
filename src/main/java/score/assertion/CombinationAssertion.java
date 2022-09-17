package score.assertion;

import score.model.Hand;

public interface CombinationAssertion {
  boolean isChecked(Hand hand);
}
