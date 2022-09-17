package score.error;

public class InvalidDiceValueException extends YatzyException {

  private static final String MESSAGE_PATTERN =
    "Dice value must be between %d and %d: actualValue=%d";

  public InvalidDiceValueException(int value, int minValue, int maxValue) {
    super(String.format(MESSAGE_PATTERN, minValue, maxValue, value));
  }
}
