package score.client.lowersection.sumofalldices;

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

class ThreeOfAKindCombinationScoreAdapterTest {

  private static ThreeOfAKindCombinationScoreAdapter threeOfAKindCombinationScoreAdapter;

  @BeforeAll
  static void init() {
    threeOfAKindCombinationScoreAdapter =
      new ThreeOfAKindCombinationScoreAdapter();
  }

  @Nested
  @DisplayName("When compute is called")
  class WhenComputeIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = threeOfAKindCombinationScoreAdapter.compute(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
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
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(2),
            new Dice(3),
            new Dice(3),
            new Dice(3)
          ),
          14
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(5),
            new Dice(5),
            new Dice(5),
            new Dice(5)
          ),
          25
        )
      );
    }
  }
}
