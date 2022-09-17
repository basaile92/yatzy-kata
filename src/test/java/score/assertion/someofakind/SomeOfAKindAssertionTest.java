package score.assertion.someofakind;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import score.error.InvalidNumberOfAKindException;

class SomeOfAKindAssertionTest {

  @Nested
  @DisplayName("When SomeOfAKindAssertion is created")
  class WhenSomeOfAKindAssertionIsCreated {

    @Nested
    @DisplayName("and number of a kind is one")
    class AndNumberOfAKindIsOne {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new SomeOfAKindAssertionTestAdapter(1))
          .isExactlyInstanceOf(InvalidNumberOfAKindException.class)
          .hasMessage(
            "Yatzy Exception: Number of a kind must be between 2 and 5: actualValue=1"
          );
      }
    }

    @Nested
    @DisplayName("and number of a kind is seven")
    class AndNumberOfAKindIsSeven {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new SomeOfAKindAssertionTestAdapter(7))
          .isExactlyInstanceOf(InvalidNumberOfAKindException.class)
          .hasMessage(
            "Yatzy Exception: Number of a kind must be between 2 and 5: actualValue=7"
          );
      }
    }

    @Nested
    @DisplayName("and number of a kind is three")
    class AndNumberOfAKindIsThree {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldNotThrowError() {
        // WHEN + THEN
        assertThatNoException()
          .isThrownBy(() -> new SomeOfAKindAssertionTestAdapter(3));
      }
    }

    private class SomeOfAKindAssertionTestAdapter extends SomeOfAKindAssertion {

      public SomeOfAKindAssertionTestAdapter(int numberOfAKind) {
        super(numberOfAKind);
      }
    }
  }
}
