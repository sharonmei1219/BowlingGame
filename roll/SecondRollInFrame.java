package roll;

import scoreKeeper.ScoreKeeper;

public class SecondRollInFrame implements Roll {
	protected int bottleCountInFirstFrame;
	private int frameCount;
	
	public SecondRollInFrame(int bottleCountIn1stRoll, int frameCount){
		this.bottleCountInFirstFrame = bottleCountIn1stRoll;
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int bottleCount, ScoreKeeper scoreKeeper) {
		scoreKeeper.scoreInNormalRoll(bottleCount);
		
		if (bottleCountInFirstFrame + bottleCount == 10) 
			scoreKeeper.spare();

		return FirstRollInFrame.nextRoll(frameCount);
	}
}