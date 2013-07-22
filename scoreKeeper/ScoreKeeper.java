package scoreKeeper;
<<<<<<< HEAD
=======

>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
import bonus.Bonus;

public class ScoreKeeper {
	public int totalScore = 0;
	public Bonus bonus = Bonus.noBonus();

<<<<<<< HEAD
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
=======
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
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		bonus = bonus.add(Bonus.strikeBonus());
	}
}
