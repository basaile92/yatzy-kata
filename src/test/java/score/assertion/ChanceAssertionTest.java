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

class ChanceAssertionTest {

  private static ChanceAssertion chanceAssertion;

  @BeforeAll
  static void init() {
    chanceAssertion = new ChanceAssertion();
  }

  @Nested
  @DisplayName("When isChecked is called")
  class WhenIsCheckedIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_true_for_any_hands(Hand hand, boolean expectedResult) {
      // WHEN
      boolean result = chanceAssertion.isChecked(hand);

      // THEN
      assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5)
          ),
          true
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          true
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          true
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          true
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          true
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          true
        )
      );
    }
  }
}
