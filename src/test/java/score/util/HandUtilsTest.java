package score.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import score.model.Dice;
import score.model.Hand;

class HandUtilsTest {

  @Nested
  @DisplayName("When numberOfIterationInHands is called")
  class WhenNumberOfIterationInHandsIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHandAndDice")
    void should_return_number_of_iteration_of_dice_in_hand(
      Dice dice,
      Hand hand,
      long expectedNumberOfIteration
    ) {
      // WHEN
      long numberOfIterations = HandUtils.numberOfIterationInHands(dice, hand);

      // THEN
      assertThat(numberOfIterations).isEqualTo(expectedNumberOfIteration);
    }

    private static Stream<Arguments> resultByProvidedHandAndDice() {
      return Stream.of(
        Arguments.of(
          new Dice(1),
          new Hand(
            new Dice(6),
            new Dice(2),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          1
        ),
        Arguments.of(
          new Dice(2),
          new Hand(
            new Dice(6),
            new Dice(3),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Dice(2),
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2)
          ),
          5
        )
      );
    }
  }

  @Nested
  @DisplayName("When numberOfIterationsByValueInHand is called")
  class WhenNumberOfIterationsByValueInHandIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHandAndDice")
    void should_return_number_of_iterations_by_dice_value_of_dice_in_hand(
      Hand hand,
      Map<Integer, Long> expectedResult
    ) {
      // WHEN
      Map<Integer, Long> numberOfIterationsByValueInHand = HandUtils.numberOfIterationsByValueInHand(
        hand
      );

      // THEN
      assertThat(numberOfIterationsByValueInHand).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> resultByProvidedHandAndDice() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(2),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          Map.of(1, 1L, 2, 1L, 4, 1L, 5, 1L, 6, 1L)
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          Map.of(1, 3L, 6, 2L)
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2)
          ),
          Map.of(2, 5L)
        )
      );
    }
  }
}
