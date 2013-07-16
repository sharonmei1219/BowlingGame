package RollingState;


public class FirstRollAfterSpare implements RollingState {

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return 2*numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(int numberOfFallenBottles) {
		if(numberOfFallenBottles == 10)
			return new FirstRollAfterStrike();
		return new SecondRoll(numberOfFallenBottles, 1);
	}

}
