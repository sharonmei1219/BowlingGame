package RollingState;



public class FirstRoll implements RollingState {

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(int numberOfFallenBottles) {
		if(numberOfFallenBottles == 10)
			return new FirstRollAfterStrike();
		return new SecondRoll(numberOfFallenBottles);
	}

}
