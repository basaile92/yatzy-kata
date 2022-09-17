package score.error;

public class InvalidPairNumberOfElementException extends YatzyException {

  private static final String MESSAGE =
    "Pair Number Of element should be between %d and %d: actualValue=%d";

  public InvalidPairNumberOfElementException(
    int actualValue,
    int minValue,
    int maxValue
  ) {
    super(String.format(MESSAGE, minValue, maxValue, actualValue));
  }
}
