package rockPaperScissors.strategies.m1ngXu;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class M1ngXUB implements Strategy {

	Choice myLastChoice;
	Choice hisLastChoice;
	boolean isPhoyhKillA;
	boolean istM1ngXUA;
	@Override
	public void initialize() {
		myLastChoice = null;
		hisLastChoice = null;
		isPhoyhKillA = false;
		istM1ngXUA = false;
	}

	@Override
	public Choice makeChoice() {
		if (isPhoyhKillA) {
			if (hisLastChoice == Choice.ROCK) return Choice.SCISSORS;
			if (hisLastChoice == Choice.PAPER) return Choice.ROCK;
			return Choice.PAPER;
		}
		
		if (istM1ngXUA) {
			if (myLastChoice == Choice.ROCK) return Choice.SCISSORS;
			if (myLastChoice == Choice.PAPER) return Choice.ROCK;
			return Choice.PAPER;
		}
		if (hisLastChoice == Choice.SCISSORS) return Choice.ROCK;
		if (hisLastChoice == Choice.PAPER) return Choice.SCISSORS;
		return Choice.PAPER;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		isPhoyhKillA = false;
		istM1ngXUA = false;
		if (hisLastChoice != null) {
			if ((myLastChoice == Choice.ROCK && hisChoice == Choice.PAPER)
					|| (myLastChoice == Choice.SCISSORS && hisChoice == Choice.ROCK)
					|| (myLastChoice == Choice.PAPER  && hisChoice == Choice.SCISSORS )) {
				istM1ngXUA = true;
			} else if ((hisLastChoice == Choice.ROCK && hisChoice == Choice.SCISSORS)
					|| (hisLastChoice == Choice.SCISSORS && hisChoice == Choice.PAPER)
					|| (hisLastChoice == Choice.PAPER  && hisChoice == Choice.ROCK )) {
				isPhoyhKillA = true;
			}
		}
		hisLastChoice = hisChoice;
		myLastChoice = myChoice;
	}
}
