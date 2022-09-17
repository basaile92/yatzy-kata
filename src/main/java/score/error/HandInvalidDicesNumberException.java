package score.error;

public class HandInvalidDicesNumberException extends YatzyException {

  private static final String MESSAGE_PATTERN =
    "Hand dices number must be five: actualSize=%d";

  public HandInvalidDicesNumberException(int size) {
    super(String.format(MESSAGE_PATTERN, size));
  }
}
