package score.error;

public class InvalidUpperSectionCombinationNumberException
  extends YatzyException {

  private static final String MESSAGE_PATTERN =
    "Upper section combination number must be between %d and %d: actualValue=%d";

  public InvalidUpperSectionCombinationNumberException(
    int number,
    int minValue,
    int maxValue
  ) {
    super(String.format(MESSAGE_PATTERN, minValue, maxValue, number));
  }
}
