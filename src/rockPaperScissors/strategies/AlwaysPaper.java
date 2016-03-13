package rockPaperScissors.strategies;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class AlwaysPaper implements Strategy {

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		return Choice.PAPER;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
