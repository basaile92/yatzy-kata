package score.client.pairsection;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import score.error.InvalidPairNumberOfElementException;

@ExtendWith(MockitoExtension.class)
class PairDicesCombinationScoreClientTest {

  @Nested
  @DisplayName("When PairDicesCombinationScoreClient is created")
  class WhenPairDicesCombinationScoreClientIsCreated {

    @Nested
    @DisplayName("and number of pair dices is zero ")
    class AndNumberOfPairDicesIsOne {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new PairDicesCombinationScoreTestAdapter(0))
          .isExactlyInstanceOf(InvalidPairNumberOfElementException.class)
          .hasMessage(
            "Yatzy Exception: Pair Number Of element should be between 1 and 2: actualValue=0"
          );
      }
    }

    @Nested
    @DisplayName("and number of pair dices is three ")
    class AndNumberOfPairDicesIsThree {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new PairDicesCombinationScoreTestAdapter(3))
          .isExactlyInstanceOf(InvalidPairNumberOfElementException.class)
          .hasMessage(
            "Yatzy Exception: Pair Number Of element should be between 1 and 2: actualValue=3"
          );
      }
    }

    @Nested
    @DisplayName("and number of pair dices is two ")
    class AndNumberOfPairDicesIsTwo {

      @DisplayName("then it should not throw error")
      @Test
      void thenItShouldNotThrowError() {
        // WHEN + THEN
        assertThatNoException()
          .isThrownBy(() -> new PairDicesCombinationScoreTestAdapter(2));
      }
    }
  }

  private static class PairDicesCombinationScoreTestAdapter
    extends PairDicesCombinationScoreClient {

    public PairDicesCombinationScoreTestAdapter(int numberOfDicesPair) {
      super(numberOfDicesPair);
    }
  }
}
