package score.assertion.straight;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import score.error.InvalidStraightNumberOfElementException;

class StraightAssertionTest {

  @Nested
  @DisplayName("When StraightAssertion is created")
  class WhenStraightAssertionIsCreated {

    @Nested
    @DisplayName("and straight number of elements is six ")
    class AndStraightNumberOfElementsIsSix {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new StraightAssertionTestAdapter(6))
          .isExactlyInstanceOf(InvalidStraightNumberOfElementException.class)
          .hasMessage(
            "Yatzy Exception: Straight Number Of element should be between 2 and 5: actualValue=6"
          );
      }
    }

    @Nested
    @DisplayName("and straight number of elements is zero")
    class AndStraightNumberOfElementsIsZero {

      @DisplayName("then it should throw error")
      @Test
      void thenItShouldThrowError() {
        // WHEN + THEN
        assertThatThrownBy(() -> new StraightAssertionTestAdapter(0))
          .isExactlyInstanceOf(InvalidStraightNumberOfElementException.class)
          .hasMessage(
            "Yatzy Exception: Straight Number Of element should be between 2 and 5: actualValue=0"
          );
      }
    }

    @Nested
    @DisplayName("and straight number of elements is 3 ")
    class AndStraightNumberOfElementsIsThree {

      @DisplayName("then it should create possible straight possibilities")
      @Test
      void thenItShouldCreatePossibleStraightPossibilities() {
        // GIVEN

        // WHEN
        StraightAssertion straightAssertion = new StraightAssertionTestAdapter(
          3
        );

        // THEN
        assertThat(straightAssertion.getPossibleFollowingNumbersList())
          .containsExactlyInAnyOrder(
            asList(1, 2, 3),
            asList(2, 3, 4),
            asList(3, 4, 5),
            asList(4, 5, 6)
          );
      }
    }

    @Nested
    @DisplayName("and straight number of elements is 4 ")
    class AndStraightNumberOfElementsIsFour {

      @DisplayName("then it should create possible straight possibilities")
      @Test
      void thenItShouldCreatePossibleStraightPossibilities() {
        // GIVEN

        // WHEN
        StraightAssertion straightAssertion = new StraightAssertionTestAdapter(
          4
        );

        // THEN
        assertThat(straightAssertion.getPossibleFollowingNumbersList())
          .containsExactlyInAnyOrder(
            asList(1, 2, 3, 4),
            asList(2, 3, 4, 5),
            asList(3, 4, 5, 6)
          );
      }
    }

    private class StraightAssertionTestAdapter extends StraightAssertion {

      public StraightAssertionTestAdapter(int straightNumberOfElements) {
        super(straightNumberOfElements);
      }
    }
  }
}
