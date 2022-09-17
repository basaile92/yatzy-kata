package score.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import score.model.Dice;
import score.model.Hand;

class YatzyAssertionTest {

  private static YatzyAssertion yatzyAssertion;

  @BeforeAll
  static void init() {
    yatzyAssertion = new YatzyAssertion();
  }

  @Nested
  @DisplayName("When isChecked is called")
  class WhenIsCheckedIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_check_if_it_has_combination_in_hand(
      Hand hand,
      boolean expectedResult
    ) {
      // WHEN
      boolean result = yatzyAssertion.isChecked(hand);

      // THEN
      assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(3)
          ),
          false
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6)
          ),
          true
        )
      );
    }
  }
}
