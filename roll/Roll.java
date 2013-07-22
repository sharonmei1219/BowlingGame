package roll;

import scoreKeeper.ScoreKeeper;

public interface Roll {
	Roll roll(int pins, ScoreKeeper scoreKeeper);
}
