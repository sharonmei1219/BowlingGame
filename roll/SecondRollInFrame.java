package roll;

import scoreKeeper.ScoreKeeper;

public class SecondRollInFrame implements Roll {
	protected int pinsInFirstFrame;
	private int frameCount;
	
	public SecondRollInFrame(int pinsIn1stRoll, int frameCount){
		this.pinsInFirstFrame = pinsIn1stRoll;
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int pins, ScoreKeeper scoreKeeper) {

		scoreKeeper.scoreForNormalRoll(pins);
		
		if (pinsInFirstFrame + pins == 10) 
			scoreKeeper.recordSpare();

		return FirstRollInFrame.nextRoll(frameCount);
	}
}