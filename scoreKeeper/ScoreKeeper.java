package scoreKeeper;

import bonus.Bonus;

public class ScoreKeeper {
	public int totalScore = 0;
	public Bonus bonus = Bonus.noBonus();

	public void scoreInNormalRoll(int bottleCount) {
		totalScore += bottleCount * (bonus.takeBonus() + 1);
		bonus = bonus.remainingBonus();
	}

	public void scoreInBonusRoll(int bottleCount) {
		totalScore += bottleCount * bonus.takeBonus();
		bonus = bonus.remainingBonus();
	}
	
	public void spare(){
		bonus = bonus.add(Bonus.spareBonus());
	}
	
	public void strike(){
		bonus = bonus.add(Bonus.strikeBonus());
	}
}
