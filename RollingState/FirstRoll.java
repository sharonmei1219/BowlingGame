package RollingState;

public class FirstRoll implements RollingState {
	
	protected int scoreFactor;
	
	public FirstRoll(int scoreFactcor){
		this.scoreFactor = scoreFactcor;
	}

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return scoreFactor * numberOfFallenBottles;
	}

	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if(numberOfFallenBottles == 10)
			return new FirstRollAfterStrike(2);
		return new SecondRoll(numberOfFallenBottles, 1);
	}

}
