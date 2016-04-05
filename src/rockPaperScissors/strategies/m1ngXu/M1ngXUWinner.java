package rockPaperScissors.strategies.m1ngXu;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;
import rockPaperScissors.strategies.SequenceMemorizer;

public class M1ngXUWinner implements Strategy {

	Strategy sm = new SequenceMemorizer();
	int loss;
	int draw;
	boolean isSm;
	boolean isPhoyh;
	
	@Override
	public void initialize() {
		sm.initialize();
		loss = 0;
		draw = 0;
		isSm = false;
		isPhoyh = false;
	}

	@Override
	public Choice makeChoice() {
		if (isSm) {
			Choice smChoice = sm.makeChoice();
			if (smChoice == Choice.PAPER) {
				return Choice.SCISSORS;
			}
			if (smChoice == Choice.SCISSORS) {
				return Choice.ROCK;
			}
			return Choice.PAPER;
		}
		if (isPhoyh) {
			Choice smChoice = sm.makeChoice();
			if (smChoice == Choice.PAPER) {
				return Choice.ROCK;
			}
			if (smChoice == Choice.SCISSORS) {
				return Choice.PAPER;
			}
			return Choice.SCISSORS;
		}
		return sm.makeChoice();
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		if (hisChoice.winsAgainst(myChoice)) {
			loss++;
			if (draw == 15 && !isSm) {
				isPhoyh = true;
			}
		}
		else if (!myChoice.winsAgainst(hisChoice)) {
			draw++;
			if (draw == 5 && !isPhoyh) {
				isSm = true;
			}
		}
		if (isSm || isPhoyh) {
			sm.notifyOfResult(hisChoice, myChoice);
		}
		else {
			sm.notifyOfResult(myChoice, hisChoice);
		}
	}

}
