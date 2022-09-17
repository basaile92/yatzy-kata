package score.model;

import java.util.Arrays;
import java.util.List;
import score.error.HandInvalidDicesNumberException;

public record Hand(List<Dice> dices) {
  public static final int MAX_NUMBER_OF_ELEMENT = 5;

  public Hand {
    checkIfHandSizeIsFive(dices);
  }

  private void checkIfHandSizeIsFive(List<Dice> dices) {
    if (dices.size() != MAX_NUMBER_OF_ELEMENT) {
      throw new HandInvalidDicesNumberException(dices.size());
    }
  }

  public Hand(Dice... dices) {
    this(Arrays.stream(dices).toList());
  }
}
