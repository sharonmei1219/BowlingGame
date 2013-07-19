package roll;

import scoreKeeper.ScoreKeeper;

public class FirstRollInFrame implements Roll {
	private int frameCount;

	public FirstRollInFrame(int frameCount) {
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int bottleCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreInNormalRoll(bottleCount);
		
		if (bottleCount == 10) {
			scoreKeeper.strike();
			return nextRoll(frameCount);
		}

		return new SecondRollInFrame(bottleCount, frameCount);
	}
	
	static public Roll nextRoll(int frameCount){
		if (frameCount + 1 == 10)
			return new BonusRoll();
		return new FirstRollInFrame(frameCount + 1);
	}
}
