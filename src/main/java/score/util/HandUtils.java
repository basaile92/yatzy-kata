package score.util;

import java.util.Map;
import java.util.stream.Collectors;
import score.model.Dice;
import score.model.Hand;

public class HandUtils {

  public static long numberOfIterationInHands(Dice value, Hand hand) {
    return hand.dices().stream().filter(value::equals).count();
  }

  public static Map<Integer, Long> numberOfIterationsByValueInHand(Hand hand) {
    return hand
      .dices()
      .stream()
      .distinct()
      .collect(
        Collectors.toMap(
          Dice::value,
          dice -> numberOfIterationInHands(dice, hand)
        )
      );
  }
}
