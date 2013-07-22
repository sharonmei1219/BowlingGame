package roll;
<<<<<<< HEAD

import scoreKeeper.ScoreKeeper;


public class BonusRoll implements Roll {

	@Override
	public Roll roll(int pins, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreForBonusRoll(pins);
=======
import scoreKeeper.ScoreKeeper;

public class BonusRoll implements Roll {

	@Override
	public Roll roll(int bottlesCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreInBonusRoll(bottlesCount);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		return new BonusRoll();
	}
}