package RollingState;

public interface RollingState {

	int scoreOfRoll(int numberOfFallenBottles);
	RollingState nextStateWhenNumberOfFallenBottlesIs(int numberOfFallenBottles);
}
