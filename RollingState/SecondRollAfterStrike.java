package RollingState;


public class SecondRollAfterStrike implements RollingState {

	private int numberOfFallenBottlesInFirstRollOfThisFrame;

	public SecondRollAfterStrike(int numberOfFallenBottlesInFirstRollOfThisFrame) {
		this.numberOfFallenBottlesInFirstRollOfThisFrame = numberOfFallenBottlesInFirstRollOfThisFrame;
	}

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return 2 * numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if (numberOfFallenBottles + numberOfFallenBottlesInFirstRollOfThisFrame == 10)
			return new FirstRollAfterSpare();
		return new FirstRoll();
	}
}
