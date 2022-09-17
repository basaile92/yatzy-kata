package score.service;

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
import score.model.Hand;

public class ScoreService {

  private final ChanceCombinationScoreAdapter chanceCombinationScoreAdapter;
  private final YatzyCombinationScoreAdapter yatzyCombinationScoreAdapter;
  private final AcesCombinationScoreAdapter acesCombinationScoreAdapter;
  private final TwosCombinationScoreAdapter twosCombinationScoreAdapter;
  private final ThreesCombinationScoreAdapter threesCombinationScoreAdapter;
  private final FoursCombinationScoreAdapter foursCombinationScoreAdapter;
  private final FivesCombinationScoreAdapter fivesCombinationScoreAdapter;
  private final SixesCombinationScoreAdapter sixesCombinationScoreAdapter;
  private final FourOfAKindCombinationScoreAdapter fourOfAKindCombinationScoreAdapter;
  private final ThreeOfAKindCombinationScoreAdapter threeOfAKindCombinationScoreAdapter;
  private final SmallStraightCombinationScoreAdapter smallStraightCombinationScoreAdapter;
  private final LargeStraightCombinationScoreAdapter largeStraightCombinationScoreAdapter;
  private final FullHouseCombinationScoreAdapter fullHouseCombinationScoreAdapter;
  private final OnePairCombinationScoreAdapter onePairCombinationScoreAdapter;
  private final TwoPairsCombinationScoreAdapter twoPairsCombinationScoreAdapter;

  public ScoreService(
    ChanceCombinationScoreAdapter chanceCombinationScoreAdapter,
    YatzyCombinationScoreAdapter yatzyCombinationScoreAdapter,
    AcesCombinationScoreAdapter acesCombinationScoreAdapter,
    TwosCombinationScoreAdapter twosCombinationScoreAdapter,
    ThreesCombinationScoreAdapter threesCombinationScoreAdapter,
    FoursCombinationScoreAdapter foursCombinationScoreAdapter,
    FivesCombinationScoreAdapter fivesCombinationScoreAdapter,
    SixesCombinationScoreAdapter sixesCombinationScoreAdapter,
    FourOfAKindCombinationScoreAdapter fourOfAKindCombinationScoreAdapter,
    ThreeOfAKindCombinationScoreAdapter threeOfAKindCombinationScoreAdapter,
    SmallStraightCombinationScoreAdapter smallStraightCombinationScoreAdapter,
    LargeStraightCombinationScoreAdapter largeStraightCombinationScoreAdapter,
    FullHouseCombinationScoreAdapter fullHouseCombinationScoreAdapter,
    OnePairCombinationScoreAdapter onePairCombinationScoreAdapter,
    TwoPairsCombinationScoreAdapter twoPairsCombinationScoreAdapter
  ) {
    this.chanceCombinationScoreAdapter = chanceCombinationScoreAdapter;
    this.yatzyCombinationScoreAdapter = yatzyCombinationScoreAdapter;
    this.acesCombinationScoreAdapter = acesCombinationScoreAdapter;
    this.twosCombinationScoreAdapter = twosCombinationScoreAdapter;
    this.threesCombinationScoreAdapter = threesCombinationScoreAdapter;
    this.foursCombinationScoreAdapter = foursCombinationScoreAdapter;
    this.fivesCombinationScoreAdapter = fivesCombinationScoreAdapter;
    this.sixesCombinationScoreAdapter = sixesCombinationScoreAdapter;
    this.fourOfAKindCombinationScoreAdapter =
      fourOfAKindCombinationScoreAdapter;
    this.threeOfAKindCombinationScoreAdapter =
      threeOfAKindCombinationScoreAdapter;
    this.smallStraightCombinationScoreAdapter =
      smallStraightCombinationScoreAdapter;
    this.largeStraightCombinationScoreAdapter =
      largeStraightCombinationScoreAdapter;
    this.fullHouseCombinationScoreAdapter = fullHouseCombinationScoreAdapter;
    this.onePairCombinationScoreAdapter = onePairCombinationScoreAdapter;
    this.twoPairsCombinationScoreAdapter = twoPairsCombinationScoreAdapter;
  }

  public int computeScoreWithChanceCombination(Hand hand) {
    return chanceCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithYatzyCombination(Hand hand) {
    return yatzyCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithAceCombination(Hand hand) {
    return acesCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithTwosCombination(Hand hand) {
    return twosCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithThreesCombination(Hand hand) {
    return threesCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithFoursCombination(Hand hand) {
    return foursCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithFivesCombination(Hand hand) {
    return fivesCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithSixesCombination(Hand hand) {
    return sixesCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithFourOfAKindCombination(Hand hand) {
    return fourOfAKindCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithThreeOfAKindCombination(Hand hand) {
    return threeOfAKindCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithSmallStraightCombination(Hand hand) {
    return smallStraightCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithLargeStraightCombination(Hand hand) {
    return largeStraightCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithFullHouseCombination(Hand hand) {
    return fullHouseCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithOnePairCombination(Hand hand) {
    return onePairCombinationScoreAdapter.compute(hand);
  }

  public int computeScoreWithTwoPairsCombination(Hand hand) {
    return twoPairsCombinationScoreAdapter.compute(hand);
  }
}
