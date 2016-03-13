package rockPaperScissors.strategies;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class AlwaysRock implements Strategy {

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		return Choice.ROCK;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
