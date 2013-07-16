package RollingState;


public class FirstRollAfterSpare implements RollingState {

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return 2*numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(int numberOfFallenBottles) {
		return null;
	}

}
