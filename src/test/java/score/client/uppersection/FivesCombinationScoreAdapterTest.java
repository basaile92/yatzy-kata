package score.client.uppersection;

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

class FivesCombinationScoreAdapterTest {

  private static FivesCombinationScoreAdapter fivesCombinationScoreAdapter;

  @BeforeAll
  static void init() {
    fivesCombinationScoreAdapter = new FivesCombinationScoreAdapter();
  }

  @Nested
  @DisplayName("When compute is called")
  class WhenComputeIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = fivesCombinationScoreAdapter.compute(hand);

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
            new Dice(1)
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
          5
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(5),
            new Dice(1),
            new Dice(5)
          ),
          10
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(1),
            new Dice(5),
            new Dice(4),
            new Dice(5)
          ),
          15
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(5),
            new Dice(5),
            new Dice(1),
            new Dice(5)
          ),
          20
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
