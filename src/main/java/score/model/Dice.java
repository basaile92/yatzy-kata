package score.model;

import score.error.InvalidDiceValueException;

public record Dice(int value) {
  public static final int DICE_MIN_VALUE = 1;
  public static final int DICE_MAX_VALUE = 6;

  public Dice {
    checkIfValueIsBetweenMinAndMaxValue(value);
  }

  private void checkIfValueIsBetweenMinAndMaxValue(int value) {
    if (value < DICE_MIN_VALUE || value > DICE_MAX_VALUE) {
      throw new InvalidDiceValueException(
        value,
        DICE_MIN_VALUE,
        DICE_MAX_VALUE
      );
    }
  }
}
