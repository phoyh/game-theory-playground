package prisonersDilemma.strategies;

import prisonersDilemma.Choice;
import prisonersDilemma.Strategy;

public class AlwaysCooperate implements Strategy {

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		return Choice.COOPERATE;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
