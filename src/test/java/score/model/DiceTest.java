package score.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import score.error.InvalidDiceValueException;

class DiceTest {

  @Nested
  @DisplayName("When a new dice is created")
  class WhenANewDiceIsCreated {

    @Nested
    @DisplayName("with negative value")
    class WithNegativeValue {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new Dice(-5))
          .isExactlyInstanceOf(InvalidDiceValueException.class)
          .hasMessage(
            "Yatzy Exception: Dice value must be between 1 and 6: actualValue=-5"
          );
      }
    }

    @Nested
    @DisplayName("with value zero")
    class WithValueZero {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new Dice(0))
          .isExactlyInstanceOf(InvalidDiceValueException.class)
          .hasMessage(
            "Yatzy Exception: Dice value must be between 1 and 6: actualValue=0"
          );
      }
    }

    @Nested
    @DisplayName("with value higher than six")
    class WithValueHigherThanSix {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new Dice(7))
          .isExactlyInstanceOf(InvalidDiceValueException.class)
          .hasMessage(
            "Yatzy Exception: Dice value must be between 1 and 6: actualValue=7"
          );
      }
    }

    @Nested
    @DisplayName("with value between one and six")
    class WithValueBetweenOneAndSix {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldNotThrowError() {
        // WHEN + THEN
        assertThatNoException().isThrownBy(() -> new Dice(6));
      }
    }
  }
}
