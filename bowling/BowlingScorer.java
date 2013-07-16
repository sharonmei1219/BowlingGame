package bowling;

import RollingState.FirstRoll;
import RollingState.RollingState;

public class BowlingScorer {

	private int _score = 0;
	private RollingState rollState = new FirstRoll(1);

	public int score() {
		return _score;
	}

	public BowlingScorer countRollOf(int numberOfFallenBottles) {
		_score  = this._score + rollState.scoreOfRoll(numberOfFallenBottles);
		rollState = this.rollState.nextStateWhenNumberOfFallenBottlesIs(numberOfFallenBottles);
		return this;
	}
}