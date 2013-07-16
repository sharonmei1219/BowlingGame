package RollingState;


public class SecondRoll implements RollingState {

	private int numberOfFallenBottlesInFirstRoll;

	public SecondRoll(int numberOfFallenBottlesInFirstRoll) {
		this.numberOfFallenBottlesInFirstRoll = numberOfFallenBottlesInFirstRoll;
	}

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(int numberOfFallenBottles) {
		if (numberOfFallenBottlesInFirstRoll + numberOfFallenBottles == 10)
			return new FirstRollAfterSpare();
		return new FirstRoll();
	}

}
