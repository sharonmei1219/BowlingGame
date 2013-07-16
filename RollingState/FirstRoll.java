package RollingState;

public class FirstRoll implements RollingState {
	protected int [] scoreFactor;
	
	public FirstRoll(int scoreFactor, int carringScoreFactor){
		this.scoreFactor = new int [2];
		this.scoreFactor[0] = scoreFactor;
		this.scoreFactor[1] = carringScoreFactor;
	}

	@Override
	public int scoreOfRoll(int numberOfFallenBottles) {
		return scoreFactor[0] * numberOfFallenBottles;
	}
	
	@Override
	public RollingState nextStateWhenNumberOfFallenBottlesIs(
			int numberOfFallenBottles) {
		if(numberOfFallenBottles == 10)
			return new FirstRollAfterStrike(scoreFactor[1] + 2, 1);
		return new SecondRoll(numberOfFallenBottles, scoreFactor[1] + 1);
	}

}
