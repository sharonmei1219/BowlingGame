package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.BowlingScorer;

public class TestingBowlingGame {
	BowlingScorer bowlingScorer = new BowlingScorer();
	
	@Test
	public void scoreIsZeroWhenThereIsNoRoll() {
		assertEquals(0, bowlingScorer.score());		
	}
	
	@Test
	public void scoreAfter2ndRollIsTheSumOfFallenBottlesIn2Rolls(){
		bowlingScorer = bowlingScorer.countRollOf(1).countRollOf(1);
		assertEquals(2, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfTheRollAfterSpareWillBeDoubled(){
		bowlingScorer = bowlingScorer.countRollOf(5)
									 .countRollOf(5)
									 .countRollOf(1);
		assertEquals(12, bowlingScorer.score());
	}
	
	
	@Test
	public void secondRollAfterSpareGetANormalScore(){
		bowlingScorer = bowlingScorer.countRollOf(5)
				                     .countRollOf(5)
				                     .countRollOf(1)
				                     .countRollOf(1);
		assertEquals(13, bowlingScorer.score());
	}
	
	@Test
	public void scoreDoubledForTheComing2RollsAfterAStrikeInFirstRollAfterSpare(){
		bowlingScorer = bowlingScorer.countRollOf(5)
				                     .countRollOf(5)
				                     .countRollOf(10)
				                     .countRollOf(1)
				                     .countRollOf(1);
		assertEquals(34, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfTheRollAfterStrikeWillBeDoubled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(1);
		assertEquals(12, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfThe2ndRollAfterStrikeWillBeDoubled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(1)
				                     .countRollOf(1);
		assertEquals(14, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfThe3rdRollAfterStrikeWillBeNormal(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(1)
				                     .countRollOf(1)
				                     .countRollOf(1);
		assertEquals(15, bowlingScorer.score());
	}
	
	@Test
	public void if2rollsAfterStrikMakesASpareThenTheScoreOfNextRollWillBeDoubled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
									 .countRollOf(5)
									 .countRollOf(5)
									 .countRollOf(1);
		assertEquals(32, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfTheRollAfter2StrikeWillBeTripled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
									 .countRollOf(10)
									 .countRollOf(1);
		assertEquals(33, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfThe2ndRollAfter2StikeWillBeDoubled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(1)
				                     .countRollOf(1);
		assertEquals(35, bowlingScorer.score());
	}
	
	@Test
	public void scoreOfTheRollAfter3StrikeWillStillBeTripled(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(1);
		assertEquals(63, bowlingScorer.score());
	}
	
//	@Test
	public void highestScoreOfGame(){
		bowlingScorer = bowlingScorer.countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10)
				                     .countRollOf(10);
		assertEquals(300, bowlingScorer.score());
	}
}
