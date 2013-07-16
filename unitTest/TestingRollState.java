package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import RollingState.FirstRoll;
import RollingState.FirstRollAfter2Strike;
import RollingState.FirstRollAfterStrike;
import RollingState.FirstRollAfterSpare;
import RollingState.RollingState;
import RollingState.SecondRoll;
import RollingState.SecondRollAfterStrike;

public class TestingRollState {

	@Test
	public void scoreOfFirstRollIsTheNumberOfFallenBottlesInTheRoll() {
		RollingState rollState = new FirstRoll();
		int score = rollState.scoreOfRoll(1);
		assertEquals(1, score);
	}
	
	@Test
	public void scoreOfRollAfterSpareIsTwiceOfTheNumberOfFallenBottlesInTheRoll(){
		RollingState rollState = new FirstRollAfterSpare();
		int score = rollState.scoreOfRoll(1);
		assertEquals(2, score);
	}
	
	@Test
	public void scoreOfSecondRollIsTheNumberOfFallenBottlesInThisRoll(){
		RollingState rollState = new SecondRoll(1);
		int score = rollState.scoreOfRoll(1);
		assertEquals(1, score);
	}
	
	@Test
	public void stateIsSecondRollAfterFirstRollInWhichTheNumberOfFallenBottlesIsLessThan10(){
		RollingState rollState = new FirstRoll();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRoll);
	}
	
	@Test
	public void stateIsFirstRollIfTheNumberOfBottlesFallInSecondRollEnoughToMakeTheScoreComeTo10InAFrame(){
		RollingState rollState = new SecondRoll(1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof FirstRoll);
	}
	
	@Test
	public void stateIsFirstRollAfterSpareWhenTheNumberOfBottlesFallInSecondRollMakeTheBottlesFallInAFrameComeTo10(){
		RollingState rollState = new SecondRoll(1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(9);
		assertTrue(rollState instanceof FirstRollAfterSpare);
	}
	
	@Test
	public  void stateIsFirstRollAfterStrikeWhenFirstRollMakes10BottleFall(){
		RollingState rollState = new FirstRoll();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfterStrike);
	}
	
	@Test
	public void scoreWillBeDoubledForTheFirstRollAfterStrike(){
		RollingState rollState = new FirstRollAfterStrike();
		assertEquals(2, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void afterFirstRollAfterStrikeIsTheStateOfSecondRollAfterStrike(){
		RollingState rollState = new FirstRollAfterStrike();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRollAfterStrike);
	}
	
	@Test
	public void scoreWillBeDoubledInSecondRollAfterStrike(){
		RollingState rollState = new SecondRollAfterStrike(1);
		assertEquals(2, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void stateChangeToFirstRollAfterTheStateOfSecondRollAfterAStrike(){
		RollingState rollState = new SecondRollAfterStrike(1);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof FirstRoll);
	}
	
	@Test
	public void secondRollAfterStrikeMakesAFrameSpareThenTheNextStateShouldBeFirstRollAfterSpare(){
		RollingState rollState = new SecondRollAfterStrike(5);
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(5);
		assertTrue(rollState instanceof FirstRollAfterSpare);
		
	}
	
	@Test
	public void stateChangeToFirstRollAfter2Strike(){
		RollingState rollState = new FirstRollAfterStrike();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfter2Strike);
	}
	
	@Test
	public void FirstRollAfter2StrikeGetScoreTrippled(){
		RollingState rollState = new FirstRollAfter2Strike();
		assertEquals(3, rollState.scoreOfRoll(1));
	}
	
	@Test
	public void nextStateWillBeTheSecondRollAfterStrikeIfTheFirstRollAfter2StrikesIsANormalRoll(){
		RollingState rollState = new FirstRollAfter2Strike();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(1);
		assertTrue(rollState instanceof SecondRollAfterStrike);
	}
	
	@Test
	public void stateChangeToFirstRollAfter2StrikeIfTheRollAfter2StrkeIsAlsoAStrike(){
		RollingState rollState = new FirstRollAfter2Strike();
		rollState = rollState.nextStateWhenNumberOfFallenBottlesIs(10);
		assertTrue(rollState instanceof FirstRollAfter2Strike);
	}
}
