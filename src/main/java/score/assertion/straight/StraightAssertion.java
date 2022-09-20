package score.assertion.straight;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;
import score.assertion.CombinationAssertion;
import score.error.InvalidStraightNumberOfElementException;
import score.model.Dice;
import score.model.Hand;

public abstract class StraightAssertion implements CombinationAssertion {

  private final List<List<Integer>> possibleFollowingNumbersList;

  protected StraightAssertion(int straightNumberOfElements) {
    checkIfStraightNumberOfElementsIsBetweenTwoAndHandMaxNumberOfElement(
      straightNumberOfElements
    );
    this.possibleFollowingNumbersList =
      createPossibleFollowingNumbersList(straightNumberOfElements);
  }

  private void checkIfStraightNumberOfElementsIsBetweenTwoAndHandMaxNumberOfElement(
    int straightNumberOfElements
  ) {
    int minValue = 2;
    if (
      straightNumberOfElements < minValue ||
      straightNumberOfElements > Hand.MAX_NUMBER_OF_ELEMENT
    ) {
      throw new InvalidStraightNumberOfElementException(
        straightNumberOfElements,
        minValue,
        Hand.MAX_NUMBER_OF_ELEMENT
      );
    }
  }

  private List<List<Integer>> createPossibleFollowingNumbersList(
    int straightNumberOfElements
  ) {
    return IntStream
      .range(
        1,
        computeNumberOfStraightPossibilities(straightNumberOfElements) + 1
      )
      .mapToObj(value ->
        IntStream
          .range(value, value + straightNumberOfElements)
          .boxed()
          .toList()
      )
      .toList();
  }

  private int computeNumberOfStraightPossibilities(
    int straightNumberOfElements
  ) {
    return (
      Dice.DICE_MAX_VALUE - Dice.DICE_MIN_VALUE - straightNumberOfElements + 2
    );
  }

  @Override
  public boolean isChecked(Hand hand) {
    return checkThatHandContainsAtLeastOneOfThePossibleFollowingNumbersListElement(
      hand
    );
  }

  private boolean checkThatHandContainsAtLeastOneOfThePossibleFollowingNumbersListElement(
    Hand hand
  ) {
    return this.possibleFollowingNumbersList.stream()
      .anyMatch(followingNumber ->
        handContainsDiceWithTheseNumbers(
          hand,
          followingNumber.stream().map(Dice::new).toList()
        )
      );
  }

  private boolean handContainsDiceWithTheseNumbers(
    Hand hand,
    List<Dice> followingNumbers
  ) {
    return new HashSet<>(hand.dices()).containsAll(followingNumbers);
  }

  public List<List<Integer>> getPossibleFollowingNumbersList() {
    return possibleFollowingNumbersList;
  }
}
