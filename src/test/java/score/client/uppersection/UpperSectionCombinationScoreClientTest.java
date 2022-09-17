package score.client.uppersection;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import score.error.InvalidUpperSectionCombinationNumberException;
import score.model.Dice;
import score.model.Hand;

class UpperSectionCombinationScoreClientTest {

  @Nested
  @DisplayName("When UpperSectionCombinationScoreAdapter is created")
  class WhenUpperSectionCombinationScoreClientIsCreated {

    @Nested
    @DisplayName("with negative number")
    class WithNegativeNumber {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() ->
            new UpperSectionCombinationScoreTestImplementation(-5)
          )
          .isExactlyInstanceOf(
            InvalidUpperSectionCombinationNumberException.class
          )
          .hasMessage(
            "Yatzy Exception: Upper section combination number must be between 1 and 6: actualValue=-5"
          );
      }
    }

    @Nested
    @DisplayName("with number zero")
    class WithNumberZero {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() ->
            new UpperSectionCombinationScoreTestImplementation(0)
          )
          .isExactlyInstanceOf(
            InvalidUpperSectionCombinationNumberException.class
          )
          .hasMessage(
            "Yatzy Exception: Upper section combination number must be between 1 and 6: actualValue=0"
          );
      }
    }

    @Nested
    @DisplayName("with number higher than six")
    class WithNumberHigherThanSix {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() ->
            new UpperSectionCombinationScoreTestImplementation(7)
          )
          .isExactlyInstanceOf(
            InvalidUpperSectionCombinationNumberException.class
          )
          .hasMessage(
            "Yatzy Exception: Upper section combination number must be between 1 and 6: actualValue=7"
          );
      }
    }

    @Nested
    @DisplayName("with number between one and six")
    class WithNumberBetweenOneAndSix {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldNotThrowError() {
        // WHEN + THEN
        assertThatNoException()
          .isThrownBy(() ->
            new UpperSectionCombinationScoreTestImplementation(6)
          );
      }
    }

    private class UpperSectionCombinationScoreTestImplementation
      extends UpperSectionCombinationScoreClient {

      public UpperSectionCombinationScoreTestImplementation(int number) {
        super(number);
      }
    }
  }

  @Nested
  @DisplayName("When compute is called")
  class WhenComputeIsCalled {

    private final int number = 5;

    private UpperSectionCombinationScoreClient upperSectionCombinationScoreClient;

    @BeforeEach
    void init() {
      upperSectionCombinationScoreClient =
        new UpperSectionCombinationScoreClient(number) {};
    }

    @Test
    @DisplayName("then it should return score")
    void thenItShouldReturnScore() {
      // GIVEN
      Hand hand = new Hand(
        new Dice(2),
        new Dice(5),
        new Dice(3),
        new Dice(1),
        new Dice(5)
      );

      // WHEN
      int result = upperSectionCombinationScoreClient.compute(hand);

      // THEN
      assertThat(result).isEqualTo(number * 2);
    }
  }
}
