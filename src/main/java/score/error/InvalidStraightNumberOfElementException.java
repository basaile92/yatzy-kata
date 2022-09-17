package score.error;

public class InvalidStraightNumberOfElementException extends YatzyException {

  private static final String MESSAGE =
    "Straight Number Of element should be between %d and %d: actualValue=%d";

  public InvalidStraightNumberOfElementException(
    int actualValue,
    int minValue,
    int maxValue
  ) {
    super(String.format(MESSAGE, minValue, maxValue, actualValue));
  }
}
