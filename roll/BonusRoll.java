package roll;

import scoreKeeper.ScoreKeeper;

public class BonusRoll implements Roll {

	@Override
	public Roll roll(int bottlesCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreInBonusRoll(bottlesCount);
		return new BonusRoll();
	}
}
