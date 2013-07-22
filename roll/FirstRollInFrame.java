package roll;

import scoreKeeper.ScoreKeeper;

public class FirstRollInFrame implements Roll {
	private int frameCount;

	public FirstRollInFrame(int frameCount) {
		this.frameCount = frameCount;
	}

	@Override
<<<<<<< HEAD
	public Roll roll(int pins, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreForNormalRoll(pins);
		
		if (pins == 10) {
			scoreKeeper.recordStrike();
			return nextRoll(frameCount);
		}

		return new SecondRollInFrame(pins, frameCount);
=======
	public Roll roll(int bottleCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreInNormalRoll(bottleCount);
		
		if (bottleCount == 10) {
			scoreKeeper.strike();
			return nextRoll(frameCount);
		}

		return new SecondRollInFrame(bottleCount, frameCount);
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
	}
	
	
	static public Roll nextRoll(int frameCount){
		if (frameCount + 1 == 10)
			return new BonusRoll();
		return new FirstRollInFrame(frameCount + 1);
	}
}
