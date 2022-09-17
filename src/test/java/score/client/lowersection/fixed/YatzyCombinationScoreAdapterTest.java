package score.client.lowersection.fixed;

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

class YatzyCombinationScoreAdapterTest {

  private static YatzyCombinationScoreAdapter yatzyCombinationScoreAdapter;

  @BeforeAll
  static void init() {
    yatzyCombinationScoreAdapter = new YatzyCombinationScoreAdapter();
  }

  @Nested
  @DisplayName("When compute is called")
  class WhenComputeIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = yatzyCombinationScoreAdapter.compute(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
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
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6)
          ),
          50
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          50
        )
      );
    }
  }
}
