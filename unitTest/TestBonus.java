package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import bonus.Bonus;

public class TestBonus {

	@Test
	public void TakeBonusFromStrikTwiceWillGet1And1() {
		Bonus bonus = Bonus.strikeBonus();
		assertEquals(1, bonus.takeBonus());
		assertEquals(1, bonus.remainingBonus().takeBonus());
	}
	
	@Test
	public void TakeBonusFromSpareTwiceWillGet1And0() {
		Bonus bonus = new Bonus(new int[]{1, 0});
		assertEquals(1, bonus.takeBonus());
		assertEquals(0, bonus.remainingBonus().takeBonus());
	}
	
	@Test
	public void TakeBonusFromNoBonusTwiceWillGet0And0() {
		Bonus bonus = new Bonus(new int[]{0, 0});
		assertEquals(0, bonus.takeBonus());
		assertEquals(0, bonus.remainingBonus().takeBonus());
	}
	
	@Test
	public void TakeBonusTwiceAfterBonusOfSpareAndBonusOfSTrikeWillGet2And1(){
		Bonus bonus = (new Bonus(new int[]{1, 0})).add(Bonus.strikeBonus());
		assertEquals(2, bonus.takeBonus());
		assertEquals(1, bonus.remainingBonus().takeBonus());	
	}
}
