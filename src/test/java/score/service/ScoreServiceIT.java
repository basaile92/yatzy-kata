package score.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import score.client.lowersection.fixed.FullHouseCombinationScoreAdapter;
import score.client.lowersection.fixed.LargeStraightCombinationScoreAdapter;
import score.client.lowersection.fixed.SmallStraightCombinationScoreAdapter;
import score.client.lowersection.fixed.YatzyCombinationScoreAdapter;
import score.client.lowersection.sumofalldices.ChanceCombinationScoreAdapter;
import score.client.lowersection.sumofalldices.FourOfAKindCombinationScoreAdapter;
import score.client.lowersection.sumofalldices.ThreeOfAKindCombinationScoreAdapter;
import score.client.pairsection.OnePairCombinationScoreAdapter;
import score.client.pairsection.TwoPairsCombinationScoreAdapter;
import score.client.uppersection.*;
import score.model.Dice;
import score.model.Hand;

public class ScoreServiceIT {

  private static ScoreService scoreService;

  @BeforeAll
  static void init() {
    scoreService =
      new ScoreService(
        new ChanceCombinationScoreAdapter(),
        new YatzyCombinationScoreAdapter(),
        new AcesCombinationScoreAdapter(),
        new TwosCombinationScoreAdapter(),
        new ThreesCombinationScoreAdapter(),
        new FoursCombinationScoreAdapter(),
        new FivesCombinationScoreAdapter(),
        new SixesCombinationScoreAdapter(),
        new FourOfAKindCombinationScoreAdapter(),
        new ThreeOfAKindCombinationScoreAdapter(),
        new SmallStraightCombinationScoreAdapter(),
        new LargeStraightCombinationScoreAdapter(),
        new FullHouseCombinationScoreAdapter(),
        new OnePairCombinationScoreAdapter(),
        new TwoPairsCombinationScoreAdapter()
      );
  }

  @Nested
  @DisplayName("When computeScoreWithChanceCombination is called")
  class WhenComputeScoreWithChanceCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithChanceCombination(hand);

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
            new Dice(5)
          ),
          20
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          13
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          5
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithYatzyCombination is called")
  class WhenComputeScoreWithYatzyCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithYatzyCombination(hand);

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

  @Nested
  @DisplayName("When computeScoreWithAceCombination is called")
  class WhenComputeScoreWithAceCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithAceCombination(hand);

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
            new Dice(5)
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
          1
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          2
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          3
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          4
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          5
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithTwosCombination is called")
  class WhenComputeScoreWithTwosCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithTwosCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(1),
            new Dice(3),
            new Dice(4),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(1),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          2
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(2),
            new Dice(5)
          ),
          4
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(4),
            new Dice(5)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2)
          ),
          8
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(2)
          ),
          10
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithThreesCombination is called")
  class WhenComputeScoreWithThreesCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithThreesCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(2),
            new Dice(1),
            new Dice(4),
            new Dice(5)
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
          3
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(3),
            new Dice(3),
            new Dice(3)
          ),
          9
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(3),
            new Dice(1),
            new Dice(3),
            new Dice(3)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(3),
            new Dice(3),
            new Dice(3),
            new Dice(3)
          ),
          15
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithFoursCombination is called")
  class WhenComputeScoreWithFoursCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithFoursCombination(hand);

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
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5)
          ),
          4
        ),
        Arguments.of(
          new Hand(
            new Dice(4),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(4)
          ),
          8
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(4),
            new Dice(4)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(4),
            new Dice(4),
            new Dice(4),
            new Dice(4)
          ),
          16
        ),
        Arguments.of(
          new Hand(
            new Dice(4),
            new Dice(4),
            new Dice(4),
            new Dice(4),
            new Dice(4)
          ),
          20
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithFivesCombination is called")
  class WhenComputeScoreWithFivesCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithFivesCombination(hand);

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

  @Nested
  @DisplayName("When computeScoreWithSixesCombination is called")
  class WhenComputeScoreWithSixesCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithSixesCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(6),
            new Dice(1),
            new Dice(5)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(6),
            new Dice(6),
            new Dice(1),
            new Dice(5)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(1),
            new Dice(4),
            new Dice(6)
          ),
          18
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(1),
            new Dice(6)
          ),
          24
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6),
            new Dice(6)
          ),
          30
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithFourOfAKindCombination is called")
  class WhenComputeScoreWithFourOfAKindCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithFourOfAKindCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(3),
            new Dice(3),
            new Dice(3),
            new Dice(5)
          ),
          17
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(1)
          ),
          5
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithThreeOfAKindCombination is called")
  class WhenComputeScoreWithThreeOfAKindCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithThreeOfAKindCombination(hand);

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
            new Dice(5)
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
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          12
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(2),
            new Dice(3),
            new Dice(3),
            new Dice(3)
          ),
          14
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

  @Nested
  @DisplayName("When computeScoreWithSmallStraightCombination is called")
  class WhenComputeScoreWithSmallStraightCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithSmallStraightCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(6),
            new Dice(3),
            new Dice(4),
            new Dice(5)
          ),
          30
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(4),
            new Dice(3),
            new Dice(5),
            new Dice(4)
          ),
          30
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5),
            new Dice(4)
          ),
          30
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(4),
            new Dice(3),
            new Dice(1),
            new Dice(2)
          ),
          30
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithLargeStraightCombination is called")
  class WhenComputeScoreWithLargeStraightCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithLargeStraightCombination(hand);

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
            new Dice(5)
          ),
          40
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(3),
            new Dice(1),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(4),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5),
            new Dice(6)
          ),
          40
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(4),
            new Dice(3),
            new Dice(1),
            new Dice(2)
          ),
          40
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithFullHouseCombination is called")
  class WhenComputeScoreWithFullHouseCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithFullHouseCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(3),
            new Dice(4),
            new Dice(5),
            new Dice(6)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(6),
            new Dice(2),
            new Dice(2),
            new Dice(2),
            new Dice(6)
          ),
          25
        ),
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(1),
            new Dice(1),
            new Dice(2),
            new Dice(2)
          ),
          25
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithOnePairCombination is called")
  class WhenComputeScoreWithOnePairCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithOnePairCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(4),
            new Dice(6),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(4),
            new Dice(3),
            new Dice(5),
            new Dice(6)
          ),
          6
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(3),
            new Dice(3),
            new Dice(3),
            new Dice(5)
          ),
          10
        ),
        Arguments.of(
          new Hand(
            new Dice(5),
            new Dice(3),
            new Dice(6),
            new Dice(6),
            new Dice(5)
          ),
          12
        )
      );
    }
  }

  @Nested
  @DisplayName("When computeScoreWithTwoPairsCombination is called")
  class WhenComputeScoreWithTwoPairsCombinationIsCalled {

    @ParameterizedTest
    @MethodSource("resultByProvidedHand")
    void should_return_expected_score_with_hand(Hand hand, int expectedScore) {
      // WHEN
      int score = scoreService.computeScoreWithTwoPairsCombination(hand);

      // THEN
      assertThat(score).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> resultByProvidedHand() {
      return Stream.of(
        Arguments.of(
          new Hand(
            new Dice(1),
            new Dice(2),
            new Dice(4),
            new Dice(6),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(2),
            new Dice(2),
            new Dice(4),
            new Dice(6),
            new Dice(5)
          ),
          0
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(3),
            new Dice(5),
            new Dice(4),
            new Dice(5)
          ),
          16
        ),
        Arguments.of(
          new Hand(
            new Dice(3),
            new Dice(3),
            new Dice(5),
            new Dice(5),
            new Dice(5)
          ),
          16
        )
      );
    }
  }
}
