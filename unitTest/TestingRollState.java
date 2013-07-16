package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import RollingState.FirstRollNormal;
import RollingState.FirstRollAfterStrike;
import RollingState.RollingState;
import RollingState.SecondRoll;

public class TestingRollState {

	@Test
	public void scoreOfFirstRollIsTheNumberOfFallenBottlesInTheRoll() {
		RollingState rollState = new FirstRollNormal(1, 0);
		int score = rollState.scoreOfRoll(1);
		assertEquals(1, score);
	}
	
	@Test
	public void scoreOfRollAfterSpareIsTwiceOfTheNumberOfFallenBottlesInTheRoll(){
		RollingState rollState = new FirstRollNormal(2, 0);
		int score = rollState.scoreOfRoll(1);
		assertEquals(2, score);
	}
	
	@Test
	public void scoreOfSecondRollIsTheNumberOfFallenBottlesInThisRoll(){
		RollingState rollState = new SecondRoll(1, 1);
		int score = rollState.scoreOfRoll(1);
		assertEquals(1, score);
	}
	
	@Test
	public void stateIsSecondRollAfterFirstRollInWhichTheNumberOfFallenBottlesIsLessThan10(){
		RollingState rollState = new FirstRollNormal(1, 0);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRoll);
	}
	
	@Test
	public void stateIsFirstRollIfTheNumberOfBottlesFallInSecondRollEnoughToMakeTheScoreComeTo10InAFrame(){
		RollingState rollState = new SecondRoll(1, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof FirstRollNormal);
	}
	
	@Test
	public void stateIsFirstRollAfterSpareWhenTheNumberOfBottlesFallInSecondRollMakeTheBottlesFallInAFrameComeTo10(){
		RollingState rollState = new SecondRoll(1, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(9);
		assertTrue(rollState instanceof FirstRollNormal);
	}
	
	@Test
	public  void stateIsFirstRollAfterStrikeWhenFirstRollMakes10BottleFall(){
		RollingState rollState = new FirstRollNormal(1, 0);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfterStrike);
	}
	
	@Test
	public void scoreWillBeDoubledForTheFirstRollAfterStrike(){
		RollingState rollState = new FirstRollAfterStrike(2, 1);
		assertEquals(2, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void afterFirstRollAfterStrikeIsTheStateOfSecondRollAfterStrike(){
		RollingState rollState = new FirstRollAfterStrike(2, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRoll);
	}
	
	@Test
	public void scoreWillBeDoubledInSecondRollAfterStrike(){
		RollingState rollState = new SecondRoll(1, 2);
		assertEquals(2, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void stateChangeToFirstRollAfterTheStateOfSecondRollAfterAStrike(){
		RollingState rollState = new SecondRoll(1, 2);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof FirstRollNormal);
	}
	
	@Test
	public void secondRollAfterStrikeMakesAFrameSpareThenTheNextStateShouldBeFirstRollAfterSpare(){
		RollingState rollState = new SecondRoll(5, 2);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(5);
		assertTrue(rollState instanceof FirstRollNormal);
		
	}
	
	@Test
	public void stateChangeToFirstRollAfter2Strike(){
		RollingState rollState = new FirstRollAfterStrike(2, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfterStrike);
	}
	
	@Test
	public void FirstRollAfter2StrikeGetScoreTrippled(){
		RollingState rollState = new FirstRollAfterStrike(3, 1);
		assertEquals(3, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void nextStateWillBeTheSecondRollAfterStrikeIfTheFirstRollAfter2StrikesIsANormalRoll(){
		RollingState rollState = new FirstRollAfterStrike(3, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRoll);
	}
	
	@Test
	public void stateChangeToFirstRollAfter2StrikeIfTheRollAfter2StrkeIsAlsoAStrike(){
		RollingState rollState = new FirstRollAfterStrike(3, 1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfterStrike);
	}
	
	@Test
	public void stateChangeToSecondRollIfFirstRollAfterSpareIsANormalRoll(){
		RollingState rollState = new FirstRollNormal(2, 0);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRoll);
	}
	
	@Test
	public void stateChangeToFirstRollAfterStrikeWhenRollsAStrikeInFirstRollAfterSpare(){
		RollingState rollState = new FirstRollNormal(2, 0);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfterStrike);
	}
}
