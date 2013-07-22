package roll;

import scoreKeeper.ScoreKeeper;


public class SecondRollInFrame implements Roll {
	protected int pinsInFirstFrame;
	private int frameCount;
	
	public SecondRollInFrame(int bottleCountIn1stRoll, int frameCount){
		this.pinsInFirstFrame = bottleCountIn1stRoll;
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int bottleCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreForNormalRoll(bottleCount);
		
		if (pinsInFirstFrame + bottleCount == 10) 
			scoreKeeper.recordSpare();

		return FirstRollInFrame.nextRoll(frameCount);
	}
}