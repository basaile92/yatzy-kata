package score.error;

public class InvalidNumberOfAKindException extends YatzyException {

  private static final String MESSAGE_PATTERN =
    "Number of a kind must be between %d and %d: actualValue=%d";

  public InvalidNumberOfAKindException(
    int numberOfKind,
    int minValue,
    int maxValue
  ) {
    super(String.format(MESSAGE_PATTERN, minValue, maxValue, numberOfKind));
  }
}
