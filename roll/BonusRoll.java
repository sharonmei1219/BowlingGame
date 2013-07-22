package roll;

import scoreKeeper.ScoreKeeper;


public class BonusRoll implements Roll {

	@Override
	public Roll roll(int pins, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreForBonusRoll(pins);
		return new BonusRoll();
	}
}