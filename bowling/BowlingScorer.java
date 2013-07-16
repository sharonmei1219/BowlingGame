package bowling;

import RollingState.FirstRollNormal;
import RollingState.RollingState;

public class BowlingScorer {

	private int _score = 0;
	private RollingState rollState = new FirstRollNormal(1, 0);

	public int score() {
		return _score;
	}

	public BowlingScorer countRollOf(int numberOfFallenBottles) {
		_score  = this._score + rollState.scoreOfRoll(numberOfFallenBottles);
		rollState = this.rollState.nextStateWhenNumberOfFallenBottlesIs(numberOfFallenBottles);
		return this;
	}
}