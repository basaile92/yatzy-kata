package score.assertion.someofakind;

import java.util.List;
import score.assertion.CombinationAssertion;
import score.error.InvalidNumberOfAKindException;
import score.model.Dice;
import score.model.Hand;
import score.util.HandUtils;

public abstract class SomeOfAKindAssertion implements CombinationAssertion {

  private final int numberOfAKind;

  public SomeOfAKindAssertion(int numberOfAKind) {
    checkIfNumberOfAKindIsBetweenTwoAndHandMaxNumberOfElements(numberOfAKind);
    this.numberOfAKind = numberOfAKind;
  }

  private void checkIfNumberOfAKindIsBetweenTwoAndHandMaxNumberOfElements(
    int numberOfAKind
  ) {
    int minValue = 2;
    if (
      numberOfAKind < minValue || numberOfAKind > Hand.MAX_NUMBER_OF_ELEMENT
    ) {
      throw new InvalidNumberOfAKindException(
        numberOfAKind,
        minValue,
        Hand.MAX_NUMBER_OF_ELEMENT
      );
    }
  }

  @Override
  public boolean isChecked(Hand hand) {
    return checkThatOneDiceValueIsPresentAtLeastNumberOfAKindTimeInHand(hand);
  }

  private boolean checkThatOneDiceValueIsPresentAtLeastNumberOfAKindTimeInHand(
    Hand hand
  ) {
    List<Dice> distinctDicesInHand = hand.dices().stream().distinct().toList();

    return distinctDicesInHand
      .stream()
      .distinct()
      .anyMatch(diceInHand ->
        HandUtils.numberOfIterationInHands(diceInHand, hand) >=
        this.numberOfAKind
      );
  }
}
