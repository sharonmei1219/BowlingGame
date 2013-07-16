package RollingState;

public class FirstRollAfter2Strike implements RollingState {

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return 3 * numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if(numberOfFallenBottles == 10)
			return new FirstRollAfter2Strike();
		return new SecondRollAfterStrike(numberOfFallenBottles);
	}
}
