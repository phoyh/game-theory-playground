package rockPaperScissors.strategies;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class AlwaysScissors implements Strategy {

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		return Choice.SCISSORS;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
