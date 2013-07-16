package RollingState;

public class FirstRollAfterStrike implements RollingState {

	protected int scoreFactor;
	
	public FirstRollAfterStrike(int scoreFactor){
		this.scoreFactor = scoreFactor;
	}
	
	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return scoreFactor * numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if (numberOfFallenBottles == 10)
			return new FirstRollAfterStrike(3);
		return new SecondRoll(numberOfFallenBottles, 2);
	}

}
