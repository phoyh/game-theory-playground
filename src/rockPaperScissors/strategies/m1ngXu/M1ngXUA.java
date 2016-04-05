package rockPaperScissors.strategies.m1ngXu;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class M1ngXUA implements Strategy {

	Choice gegnerGemacht = Choice.PAPER;
	
	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		if (gegnerGemacht == Choice.ROCK) return Choice.PAPER;
		if (gegnerGemacht == Choice.PAPER) return Choice.SCISSORS;
		return Choice.ROCK;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		gegnerGemacht = hisChoice;
	}

}
