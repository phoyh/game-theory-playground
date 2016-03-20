package prisonersDilemma.strategies;

import prisonersDilemma.Choice;
import prisonersDilemma.Strategy;

public class AlwaysDefect implements Strategy {

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		return Choice.DEFECT;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
