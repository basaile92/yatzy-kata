package score.error;

public class YatzyException extends RuntimeException {

  private static final String MESSAGE_PATTERN = "Yatzy Exception: %s";

  public YatzyException(String message) {
    super(String.format(MESSAGE_PATTERN, message));
  }
}
