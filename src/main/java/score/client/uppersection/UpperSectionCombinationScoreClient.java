package score.client.uppersection;

import score.client.CombinationScoreClient;
import score.error.InvalidUpperSectionCombinationNumberException;
import score.model.Dice;
import score.model.Hand;

public abstract class UpperSectionCombinationScoreClient
  implements CombinationScoreClient {

  private final int value;

  protected UpperSectionCombinationScoreClient(int value) {
    checkIfNumberIsBetweenDiceMinValueAndDiceMaxValue(value);
    this.value = value;
  }

  private void checkIfNumberIsBetweenDiceMinValueAndDiceMaxValue(int number) {
    if (number < Dice.DICE_MIN_VALUE || number > Dice.DICE_MAX_VALUE) {
      throw new InvalidUpperSectionCombinationNumberException(
        number,
        Dice.DICE_MIN_VALUE,
        Dice.DICE_MAX_VALUE
      );
    }
  }

  @Override
  public int compute(Hand hand) {
    return hand
      .dices()
      .stream()
      .map(Dice::value)
      .filter(diceValue -> diceValue == this.value)
      .reduce(Integer::sum)
      .orElse(0);
  }
}
