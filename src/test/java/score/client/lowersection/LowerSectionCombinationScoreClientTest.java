package score.client.lowersection;

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
class LowerSectionCombinationScoreClientTest {

  @Mock
  private CombinationAssertion combinationAssertion;

  private LowerSectionCombinationScoreClient lowerSectionCombinationScoreClient;

  @BeforeEach
  void init() {
    lowerSectionCombinationScoreClient =
      new LowerSectionCombinationScoreClient(combinationAssertion) {
        @Override
        public int compute(Hand hand) {
          return 0;
        }
      };
  }

  @Nested
  @DisplayName("When check assertion is called")
  class WhenCheckAssertionIsCalled {

    @Test
    @DisplayName("then it should return check assertion returned value")
    void thenItShouldReturnScore() {
      // GIVEN
      boolean returnedValue = true;
      Hand hand = new Hand(
        new Dice(2),
        new Dice(2),
        new Dice(3),
        new Dice(1),
        new Dice(5)
      );
      when(combinationAssertion.isChecked(hand)).thenReturn(returnedValue);

      // WHEN
      boolean result = lowerSectionCombinationScoreClient.checkAssertion(hand);

      // THEN
      assertThat(result).isEqualTo(returnedValue);
      verify(combinationAssertion).isChecked(hand);
    }
  }
}
