package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import roll.BonusRoll;
import roll.FirstRollInFrame;
import roll.Roll;
import roll.SecondRollInFrame;
import scoreKeeper.ScoreKeeper;

public class TestRollState {
	
	Roll rollState;
	ScoreKeeper scoreKeeper = new ScoreKeeper();
	
	@Test
	public void stateChangeFromFirstRollToSecondRollWhenBottleCountInFirstRollIsNot10(){
		rollState = new FirstRollInFrame(0);
		assertTrue(rollState.roll(1, scoreKeeper) instanceof SecondRollInFrame);
	}
	
	@Test
	public void stateChangeFromFirstRollToFirstRollWhenBottleCountIs10InFirstRoll()	{
		rollState = new FirstRollInFrame(0);
		assertTrue(rollState.roll(10, scoreKeeper) instanceof FirstRollInFrame);
	}
	
	@Test
	public void stateChangeFromSecondRollToFirstRoll(){
		rollState = new SecondRollInFrame(0, 0);
		assertTrue(rollState.roll(1, scoreKeeper) instanceof FirstRollInFrame);
	}
	
	@Test
	public void stateChangeFromFirstRollToBonusRollWhenTheBottleCountIs10InTheFirstRollOf9thFrame(){
		rollState = new FirstRollInFrame(9);
		assertTrue(rollState.roll(10, scoreKeeper) instanceof BonusRoll);
	}
	
	@Test
	public void stateChangeFromSecondRollToBonusRollAfterTheSecondRollIn9thFrame(){
		rollState = new SecondRollInFrame(1, 9);
		assertTrue(rollState.roll(1, scoreKeeper) instanceof BonusRoll);
	}
	
	@Test
	public void stateChangeFromBonusRollToBonusRollWhatever(){
		rollState = new BonusRoll();
		assertTrue(rollState.roll(1, scoreKeeper) instanceof BonusRoll);
	}

}
