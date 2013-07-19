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
									 .roll(5, scoreKeeper)
									 .roll(5, scoreKeeper)
									 .roll(1, scoreKeeper);
		assertEquals(32, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfter2StrikeWillBeTripled(){
		roller = roller.roll(10, scoreKeeper)
									 .roll(10, scoreKeeper)
									 .roll(1, scoreKeeper);
		assertEquals(33, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfThe2ndRollAfter2StikeWillBeDoubled(){
		roller = roller.roll(10, scoreKeeper)
				                     .roll(10, scoreKeeper)
				                     .roll(1, scoreKeeper)
				                     .roll(1, scoreKeeper);
		assertEquals(35, scoreKeeper.totalScore);
	}
	
	@Test
	public void scoreOfTheRollAfter3StrikeWillStillBeTripled(){
		roller = roller.roll(10, scoreKeeper)
				                     .roll(10, scoreKeeper)
				                     .roll(10, scoreKeeper)
				                     .roll(1, scoreKeeper);
		assertEquals(63, scoreKeeper.totalScore);
	}
	
	@Test
	public void highestScoreOfGame(){
		roller = scoreOf0(roller, 9);
		roller = roller.roll(10, scoreKeeper)
				                     .roll(1, scoreKeeper)
				                     .roll(1, scoreKeeper);
		
		assertEquals(12, scoreKeeper.totalScore);
	}
	
	@Test
	public void WhenLastFrameIsSpareOnlyCountTheFirstRollAfterTheFinalFrame(){
		roller = scoreOf0(roller, 9);
		roller = roller.roll(5, scoreKeeper)
				                     .roll(5, scoreKeeper)
				                     .roll(1, scoreKeeper)
				                     .roll(1, scoreKeeper);
		assertEquals(11, scoreKeeper.totalScore);
	}
	
	
	private Roll scoreOf0(Roll roller, int numberOfFame){
		for(int i = 0; i < 2* numberOfFame; i ++)
			roller = roller.roll(0, scoreKeeper);
			
		return roller;
	}
}
