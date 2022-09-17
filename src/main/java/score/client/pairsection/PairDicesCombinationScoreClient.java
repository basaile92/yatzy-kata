package score.client.pairsection;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import score.client.CombinationScoreClient;
import score.error.InvalidPairNumberOfElementException;
import score.model.Hand;
import score.util.HandUtils;

public abstract class PairDicesCombinationScoreClient
  implements CombinationScoreClient {

  private final int numberOfDicesPair;

  public PairDicesCombinationScoreClient(int numberOfDicesPair) {
    checkIfNumberOfDicesPairIsBetweenOneAndHandMaxNumberOfElementDividedByTwo(
      numberOfDicesPair
    );
    this.numberOfDicesPair = numberOfDicesPair;
  }

  private void checkIfNumberOfDicesPairIsBetweenOneAndHandMaxNumberOfElementDividedByTwo(
    int numberOfDicesPair
  ) {
    int minValue = 1;
    if (
      numberOfDicesPair < minValue ||
      numberOfDicesPair > Hand.MAX_NUMBER_OF_ELEMENT / 2
    ) {
      throw new InvalidPairNumberOfElementException(
        numberOfDicesPair,
        minValue,
        Hand.MAX_NUMBER_OF_ELEMENT / 2
      );
    }
  }

  @Override
  public int compute(Hand hand) {
    return getSumOfMaxPairsDiceOrZero(hand);
  }

  private int getSumOfMaxPairsDiceOrZero(Hand hand) {
    List<Map.Entry<Integer, Long>> pairsElement = HandUtils
      .numberOfIterationsByValueInHand(hand)
      .entrySet()
      .stream()
      .filter(entry -> entry.getValue() >= 2)
      .toList();
    if (pairsElement.size() < this.numberOfDicesPair) return 0;
    return (
      2 *
      pairsElement
        .stream()
        .map(Map.Entry::getKey)
        .sorted(Integer::compare)
        .sorted(Comparator.reverseOrder())
        .limit(this.numberOfDicesPair)
        .reduce(Integer::sum)
        .orElse(0)
    );
  }
}
