package score.assertion;

import static java.util.Arrays.asList;

import java.util.HashSet;
import score.model.Hand;
import score.util.HandUtils;

public class FullHouseAssertion implements CombinationAssertion {

  @Override
  public boolean isChecked(Hand hand) {
    return checkThatOneElementHasTwoIterationsAndTheOtherHasThreeIterationInHand(
      hand
    );
  }

  private boolean checkThatOneElementHasTwoIterationsAndTheOtherHasThreeIterationInHand(
    Hand hand
  ) {
    return new HashSet<>(
      HandUtils.numberOfIterationsByValueInHand(hand).values().stream().toList()
    )
      .containsAll(asList(2L, 3L));
  }
}
