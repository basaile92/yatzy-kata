package score.client;

import score.model.Hand;

public interface CombinationScoreClient {
  int compute(Hand hand);
}
