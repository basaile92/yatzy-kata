package score.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import score.error.HandInvalidDicesNumberException;

class HandTest {

  @Nested
  @DisplayName("When a new hand is created")
  class WhenANewHandIsCreated {

    @Nested
    @DisplayName("with no value")
    class WithNoValue {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(Hand::new)
          .isExactlyInstanceOf(HandInvalidDicesNumberException.class)
          .hasMessage(
            "Yatzy Exception: Hand dices number must be five: actualSize=0"
          );
      }
    }

    @Nested
    @DisplayName("with four values")
    class WithFourValues {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() ->
            new Hand(new Dice(1), new Dice(2), new Dice(3), new Dice(4))
          )
          .isExactlyInstanceOf(HandInvalidDicesNumberException.class)
          .hasMessage(
            "Yatzy Exception: Hand dices number must be five: actualSize=4"
          );
      }
    }

    @Nested
    @DisplayName("with six values")
    class WithSixValues {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() ->
            new Hand(
              new Dice(1),
              new Dice(2),
              new Dice(3),
              new Dice(4),
              new Dice(5),
              new Dice(6)
            )
          )
          .isExactlyInstanceOf(HandInvalidDicesNumberException.class)
          .hasMessage(
            "Yatzy Exception: Hand dices number must be five: actualSize=6"
          );
      }
    }

    @Nested
    @DisplayName("with five values")
    class WithFiveValues {

      @Test
      @DisplayName("then it should throw error")
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatNoException()
          .isThrownBy(() ->
            new Hand(
              new Dice(1),
              new Dice(2),
              new Dice(3),
              new Dice(4),
              new Dice(5)
            )
          );
      }
    }
  }
}
