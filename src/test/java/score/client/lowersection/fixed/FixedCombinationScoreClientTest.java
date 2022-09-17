package score.client.lowersection.fixed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import score.assertion.CombinationAssertion;
import score.model.Dice;
import score.model.Hand;

@ExtendWith(MockitoExtension.class)
class FixedCombinationScoreClientTest {

  @Mock
  private CombinationAssertion combinationAssertion;

  private final int score = 10;

  private FixedCombinationScoreClient fixedCombinationScoreClient;

  @BeforeEach
  void init() {
    fixedCombinationScoreClient =
      new FixedCombinationScoreClient(combinationAssertion, score) {};
  }

  @Nested
  @DisplayName("When compute is called")
  class WhenComputeIsCalled {

    @Nested
    @DisplayName("And assertion is true")
    class AndAssertionIsTrue {

      @Test
      @DisplayName("then it should return score")
      void thenItShouldReturnScore() {
        // GIVEN
        Hand hand = new Hand(
          new Dice(2),
          new Dice(2),
          new Dice(3),
          new Dice(1),
          new Dice(5)
        );
        when(combinationAssertion.isChecked(hand)).thenReturn(true);

        // WHEN
        int result = fixedCombinationScoreClient.compute(hand);

        // THEN
        assertThat(result).isEqualTo(score);
        verify(combinationAssertion).isChecked(hand);
      }
    }

    @Nested
    @DisplayName("And assertion is false")
    class AndAssertionIsFalse {

      @Test
      @DisplayName("then it should return zero")
      void thenItShouldReturnZero() {
        // GIVEN
        Hand hand = new Hand(
          new Dice(2),
          new Dice(2),
          new Dice(3),
          new Dice(1),
          new Dice(5)
        );
        when(combinationAssertion.isChecked(hand)).thenReturn(false);

        // WHEN
        int result = fixedCombinationScoreClient.compute(hand);

        // THEN
        assertThat(result).isEqualTo(0);
        verify(combinationAssertion).isChecked(hand);
      }
    }
  }
}
