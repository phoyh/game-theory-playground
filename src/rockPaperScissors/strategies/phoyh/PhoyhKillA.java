package rockPaperScissors.strategies.phoyh;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class PhoyhKillA implements Strategy {

	boolean isM1ngXUA;
	Choice myLastChoice;
	Choice hisLastChoice;
	
	@Override
	public void initialize() {
		myLastChoice = null;
		hisLastChoice = null;
		isM1ngXUA = false;
	}

	@Override
	public Choice makeChoice() {
		if (isM1ngXUA) {
			if (myLastChoice == Choice.ROCK) return Choice.SCISSORS;
			if (myLastChoice == Choice.PAPER) return Choice.ROCK;
			return Choice.PAPER;
		}
		if (hisLastChoice == Choice.ROCK) return Choice.PAPER;
		if (hisLastChoice == Choice.PAPER) return Choice.SCISSORS;
		return Choice.ROCK;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		if (hisLastChoice != null && hisLastChoice != hisChoice) {
			isM1ngXUA = true;
		}
		hisLastChoice = hisChoice;
		myLastChoice = myChoice;
	}

}
