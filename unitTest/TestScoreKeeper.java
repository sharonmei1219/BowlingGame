package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import scoreKeeper.ScoreKeeper;
import bonus.Bonus;

public class TestScoreKeeper {

	@Test
	public void scoreForANormalRollIsTheBonusPlus1TimesOfBottleCountInTheRoll() {
		ScoreKeeper scoreKeeper = new ScoreKeeper();
		scoreKeeper.bonus = Bonus.spareBonus();
		scoreKeeper.scoreInNormalRoll(1);
		assertEquals(2, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreForABonusRollIsTheBonusTimesOfBottleCountInTheRoll(){
		ScoreKeeper scoreKeeper = new ScoreKeeper();
		scoreKeeper.bonus = Bonus.spareBonus();
		scoreKeeper.scoreInBonusRoll(1);
		assertEquals(1, scoreKeeper.totalScore);
	}

}
