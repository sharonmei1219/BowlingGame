package unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import roll.FirstRollInFrame;
import roll.Roll;
import scoreKeeper.ScoreKeeper;

public class TesBowlingGame {
	Roll roller = new FirstRollInFrame(0);
	ScoreKeeper scoreKeeper = new ScoreKeeper();
	
	@Test
	public void scoreIsZeroWhenThereIsNoRoll() {
		assertEquals(0, scoreKeeper.totalScore);		
	}
	
	@Test
	public void scoreAfter2ndRollIsTheSumOfFallenBottlesIn2Rolls(){
		roller = roller.roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(2, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfterSpareWillBeDoubled(){
		roller = roller.roll(5, scoreKeeper)
					   .roll(5, scoreKeeper)
					   .roll(1, scoreKeeper);
		assertEquals(12, scoreKeeper.totalScore);
	}
	
	
	@Test
	public void secondRollAfterSpareGetANormalScore(){
		roller = roller.roll(5, scoreKeeper)
				       .roll(5, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(13, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreDoubledForTheComing2RollsAfterAStrikeInFirstRollAfterSpare(){
		roller = roller.roll(5, scoreKeeper)
				       .roll(5, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(34, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfterStrikeWillBeDoubled(){
		roller = roller.roll(10, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(12, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfThe2ndRollAfterStrikeWillBeDoubled(){
		roller = roller.roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(14, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfThe3rdRollAfterStrikeWillBeNormal(){
		roller = roller.roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(15, scoreKeeper.totalScore);
	}
	
	@Test
	public void if2rollsAfterStrikMakesASpareThenTheScoreOfNextRollWillBeDoubled(){
		roller = roller.roll(10, scoreKeeper)
<<<<<<< HEAD
					   .roll(5, scoreKeeper)
					   .roll(5, scoreKeeper)
					   .roll(1, scoreKeeper);
=======
									 .roll(5, scoreKeeper)
									 .roll(5, scoreKeeper)
									 .roll(1, scoreKeeper);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(32, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfter2StrikeWillBeTripled(){
		roller = roller.roll(10, scoreKeeper)
<<<<<<< HEAD
					   .roll(10, scoreKeeper)
					   .roll(1, scoreKeeper);
=======
									 .roll(10, scoreKeeper)
									 .roll(1, scoreKeeper);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(33, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfThe2ndRollAfter2StikeWillBeDoubled(){
		roller = roller.roll(10, scoreKeeper)
<<<<<<< HEAD
				       .roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
=======
				                     .roll(10, scoreKeeper)
				                     .roll(1, scoreKeeper)
				                     .roll(1, scoreKeeper);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(35, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfter3StrikeWillStillBeTripled(){
		roller = roller.roll(10, scoreKeeper)
<<<<<<< HEAD
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(1, scoreKeeper);
=======
				                     .roll(10, scoreKeeper)
				                     .roll(10, scoreKeeper)
				                     .roll(1, scoreKeeper);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		assertEquals(63, scoreKeeper.totalScore);
	}
	
	@Test
	public void last2BonusRollWillCountInScoreIfTheLastRollIsStrike(){
		roller = new FirstRollInFrame(9);
		roller = roller.roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		
		assertEquals(12, scoreKeeper.totalScore);
	}
	
	@Test
	public void WhenLastFrameIsSpareOnlyCountTheFirstRollAfterTheFinalFrame(){
		roller = new FirstRollInFrame(9);
		roller = roller.roll(5, scoreKeeper)
				       .roll(5, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(11, scoreKeeper.totalScore);
	}
	
	@Test
	public void TheRollBeforeWillGetDoubleScoreAndTheLastRollWillGet1TimeScoreWhenLast2FramesAreStrike(){
		Roll roller = new FirstRollInFrame(8);
		roller = roller.roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(1, scoreKeeper)
				       .roll(1, scoreKeeper);
		assertEquals(33, scoreKeeper.totalScore);
	}
	
	@Test
	public void HighestScoreIs300(){
		roller = new FirstRollInFrame(0);
		roller = roller.roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper)
				       .roll(10, scoreKeeper);
		assertEquals(300, scoreKeeper.totalScore);
	}
	
}
