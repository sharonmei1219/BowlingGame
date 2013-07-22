package roll;

import scoreKeeper.ScoreKeeper;

public class FirstRollInFrame implements Roll {
	private int frameCount;

	public FirstRollInFrame(int frameCount) {
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int pins, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreForNormalRoll(pins);
		
		if (pins == 10) {
			scoreKeeper.recordStrike();
			return nextRoll(frameCount);
		}

		return new SecondRollInFrame(pins, frameCount);
	}
	
	
	static public Roll nextRoll(int frameCount){
		if (frameCount + 1 == 10)
			return new BonusRoll();
		return new FirstRollInFrame(frameCount + 1);
	}
}
