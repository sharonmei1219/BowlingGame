package RollingState;

public class SecondRoll implements RollingState {
	
	protected int numberOfFallenBottlesInFirstRoll;
	protected int scoreFactor;
	
	public SecondRoll(int numberOfFallenBottlesInFirstRoll, int scoreFactor){
		this.numberOfFallenBottlesInFirstRoll = numberOfFallenBottlesInFirstRoll;
		this.scoreFactor = scoreFactor;
	}

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return scoreFactor * numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if (numberOfFallenBottlesInFirstRoll + numberOfFallenBottles == 10)
			return new FirstRollAfterSpare();
		return new FirstRollNormal();
	}

}
