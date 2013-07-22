package roll;

import scoreKeeper.ScoreKeeper;

<<<<<<< HEAD

public class SecondRollInFrame implements Roll {
	protected int pinsInFirstFrame;
	private int frameCount;
	
	public SecondRollInFrame(int bottleCountIn1stRoll, int frameCount){
		this.pinsInFirstFrame = bottleCountIn1stRoll;
=======
public class SecondRollInFrame implements Roll {
	protected int bottleCountInFirstFrame;
	private int frameCount;
	
	public SecondRollInFrame(int bottleCountIn1stRoll, int frameCount){
		this.bottleCountInFirstFrame = bottleCountIn1stRoll;
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6
		this.frameCount = frameCount;
	}

	@Override
	public Roll roll(int bottleCount, ScoreKeeper scoreKeeper) {
<<<<<<< HEAD
		scoreKeeper.scoreForNormalRoll(bottleCount);
		
		if (pinsInFirstFrame + bottleCount == 10) 
			scoreKeeper.recordSpare();
=======
		scoreKeeper.scoreInNormalRoll(bottleCount);
		
		if (bottleCountInFirstFrame + bottleCount == 10) 
			scoreKeeper.spare();
>>>>>>> eefc88f065b9a7e895a48d17159157192f31b0c6

		return FirstRollInFrame.nextRoll(frameCount);
	}
}