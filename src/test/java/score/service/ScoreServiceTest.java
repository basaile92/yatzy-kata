package score.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

@ExtendWith(MockitoExtension.class)
class ScoreServiceTest {

  @Mock
  private ChanceCombinationScoreAdapter chanceCombinationScoreAdapter;

  @Mock
  private YatzyCombinationScoreAdapter yatzyCombinationScoreAdapter;

  @Mock
  private AcesCombinationScoreAdapter acesCombinationScoreAdapter;

  @Mock
  private TwosCombinationScoreAdapter twosCombinationScoreAdapter;

  @Mock
  private ThreesCombinationScoreAdapter threesCombinationScoreAdapter;

  @Mock
  private FoursCombinationScoreAdapter foursCombinationScoreAdapter;

  @Mock
  private FivesCombinationScoreAdapter fivesCombinationScoreAdapter;

  @Mock
  private SixesCombinationScoreAdapter sixesCombinationScoreAdapter;

  @Mock
  private FourOfAKindCombinationScoreAdapter fourOfAKindCombinationScoreAdapter;

  @Mock
  private ThreeOfAKindCombinationScoreAdapter threeOfAKindCombinationScoreAdapter;

  @Mock
  private SmallStraightCombinationScoreAdapter smallStraightCombinationScoreAdapter;

  @Mock
  private LargeStraightCombinationScoreAdapter largeStraightCombinationScoreAdapter;

  @Mock
  private FullHouseCombinationScoreAdapter fullHouseCombinationScoreAdapter;

  @Mock
  private OnePairCombinationScoreAdapter onePairCombinationScoreAdapter;

  @Mock
  private TwoPairsCombinationScoreAdapter twoPairsCombinationScoreAdapter;

  @InjectMocks
  private ScoreService scoreService;

  @Test
  @DisplayName(
    "When computeScoreWithChanceCombination is called then it should call chanceCombinationScoreAdapter computation"
  )
  void computeScoreWithChanceCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(chanceCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithChanceCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(chanceCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithYatzyCombination is called then it should call yatzyCombinationScoreAdapter computation"
  )
  void computeScoreWithYatzyCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(yatzyCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithYatzyCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(yatzyCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithAceCombination is called then it should call acesCombinationScoreAdapter computation"
  )
  void computeScoreWithAceCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(acesCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithAceCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(acesCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithTwosCombination is called then it should call twosCombinationScoreAdapter computation"
  )
  void computeScoreWithTwosCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(twosCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithTwosCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(twosCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithThreesCombination is called then it should call threesCombinationScoreAdapter computation"
  )
  void computeScoreWithThreesCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(threesCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithThreesCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(threesCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithFoursCombination is called then it should call foursCombinationScoreAdapter computation"
  )
  void computeScoreWithFoursCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(foursCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithFoursCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(foursCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithFivesCombination is called then it should call fivesCombinationScoreAdapter computation"
  )
  void computeScoreWithFivesCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(fivesCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithFivesCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(fivesCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithSixesCombination is called then it should call sixesCombinationScoreAdapter computation"
  )
  void computeScoreWithSixesCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(sixesCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithSixesCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(sixesCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithFourOfAKindCombination is called then it should call fourOfAKindCombinationScoreAdapter computation"
  )
  void computeScoreWithFourOfAKindCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(fourOfAKindCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithFourOfAKindCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(fourOfAKindCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithThreeOfAKindCombination is called then it should call threeOfAKindCombinationScoreAdapter computation"
  )
  void computeScoreWithThreeOfAKindCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(threeOfAKindCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithThreeOfAKindCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(threeOfAKindCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithSmallStraightCombination is called then it should call smallStraightCombinationScoreAdapter computation"
  )
  void computeScoreWithSmallStraightCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(smallStraightCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithSmallStraightCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(smallStraightCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithLargeStraightCombination is called then it should call largeStraightCombinationScoreAdapter computation"
  )
  void computeScoreWithLargeStraightCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(largeStraightCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithLargeStraightCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(largeStraightCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithFullHouseCombination is called then it should call fullHouseCombinationScoreAdapter computation"
  )
  void computeScoreWithFullHouseCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(fullHouseCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithFullHouseCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(fullHouseCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithOnePairCombination is called then it should call onePairCombinationScoreAdapter computation"
  )
  void computeScoreWithOnePairCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(onePairCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithOnePairCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(onePairCombinationScoreAdapter).compute(hand);
  }

  @Test
  @DisplayName(
    "When computeScoreWithTwoPairsCombination is called then it should call twoPairsCombinationScoreAdapter computation"
  )
  void computeScoreWithTwoPairsCombination() {
    // GIVEN
    Hand hand = new Hand(
      new Dice(6),
      new Dice(2),
      new Dice(3),
      new Dice(4),
      new Dice(5)
    );
    int expectedScore = 10;
    when(twoPairsCombinationScoreAdapter.compute(hand)).thenReturn(expectedScore);

    // WHEN
    int result = scoreService.computeScoreWithTwoPairsCombination(hand);

    // THEN
    assertThat(result).isEqualTo(expectedScore);
    verify(twoPairsCombinationScoreAdapter).compute(hand);
  }
}
