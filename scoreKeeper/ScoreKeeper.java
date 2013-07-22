package scoreKeeper;
import bonus.Bonus;

public class ScoreKeeper {
	public int totalScore = 0;
	public Bonus bonus = Bonus.noBonus();

	public void scoreForNormalRoll(int pins) {
		totalScore += pins * (bonus.takeBonus() + 1);
		bonus = bonus.remainingBonus();
	}

	public void scoreForBonusRoll(int pins) {
		totalScore += pins * bonus.takeBonus();
		bonus = bonus.remainingBonus();
	}
	
	public void recordSpare(){
		bonus = bonus.add(Bonus.spareBonus());
	}
	
	public void recordStrike(){
		bonus = bonus.add(Bonus.strikeBonus());
	}
}
