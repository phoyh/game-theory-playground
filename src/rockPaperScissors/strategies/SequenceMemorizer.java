package rockPaperScissors.strategies;

import java.util.HashMap;
import java.util.Map;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class SequenceMemorizer implements Strategy {

	Map<String,Choice> choiceMemory;
	String choiceHistory;
	
	@Override
	public void initialize() {
		choiceMemory = new HashMap<String,Choice>();
		choiceHistory = "";
	}

	@Override
	public Choice makeChoice() {
		Choice c = getPredictedChoice();
		if (c == Choice.ROCK) return Choice.PAPER;
		if (c == Choice.PAPER) return Choice.SCISSORS;
		return Choice.ROCK;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		rememberChoiceForHistory(hisChoice);
		choiceHistory += getChoicePairCode(myChoice, hisChoice);
	}
	
	private Choice getPredictedChoice() {
		for (int i = 1; i <= choiceHistory.length(); i++) {
			String consideredSubHistory = choiceHistory.substring(i);
			Choice c = choiceMemory.get(consideredSubHistory);
			if (c != null) return c;
		}
		return null;
	}
	
	private void rememberChoiceForHistory(Choice hisChoice) {
		for (int i = 0; i <= choiceHistory.length(); i++) {
			String consideredSubHistory = choiceHistory.substring(i);
			choiceMemory.put(consideredSubHistory, hisChoice);
		}
	}
	
	private char getChoicePairCode(Choice myChoice, Choice hisChoice) {
		switch (myChoice) {
			case ROCK:
				switch (hisChoice) {
					case ROCK: return '1';
					case PAPER: return '2';
					default: return '3';
				}
			case PAPER:
				switch (hisChoice) {
					case ROCK: return '4';
					case PAPER: return '5';
					default: return '6';
				}
			default:
				switch (hisChoice) {
					case ROCK: return '7';
					case PAPER: return '8';
					default: return '9';
				}
		}
	}

}
