package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import scoreKeeper.ScoreKeeper;
import bonus.Bonus;

public class TestScoreKeeper {

	@Test
	public void scoreForANormalRollIsTheBonusPlus1TimesOfBottleCountInTheRoll() {
		ScoreKeeper scoreKeeper = new ScoreKeeper();
		scoreKeeper.bonus = new Bonus(new int[]{1, 0});
<<<<<<< HEAD
		scoreKeeper.scoreForNormalRoll(1);
=======
		scoreKeeper.scoreInNormalRoll(1);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(2, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreForABonusRollIsTheBonusTimesOfBottleCountInTheRoll(){
		ScoreKeeper scoreKeeper = new ScoreKeeper();
		scoreKeeper.bonus = new Bonus(new int[]{1, 0});
<<<<<<< HEAD
		scoreKeeper.scoreForBonusRoll(1);
=======
		scoreKeeper.scoreInBonusRoll(1);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(1, scoreKeeper.totalScore);
	}

}
