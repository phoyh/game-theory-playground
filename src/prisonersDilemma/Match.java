package prisonersDilemma;

public class Match {
	Strategy firstOpponent;
	Strategy secondOpponent;
	int numberOfRounds;
	int firstPayoff;
	int secondPayoff;
	boolean isShowRoundResult;
	boolean isShowMatchResult;
	
	public Match(Strategy firstOpponent, Strategy secondOpponent,
			int numberOfRounds,
			boolean isShowRoundResult, boolean isShowMatchResult) {
		this.firstOpponent = firstOpponent;
		this.secondOpponent = secondOpponent;
		this.numberOfRounds = numberOfRounds;
		this.isShowRoundResult = isShowRoundResult;
		this.isShowMatchResult = isShowMatchResult;
	}
	
	public void play() {
		this.firstOpponent.initialize();
		this.secondOpponent.initialize();
		this.firstPayoff = 0;
		this.secondPayoff = 0;
		if (this.isShowRoundResult) this.showMatchResult();
		for (int i = 0; i < numberOfRounds; i++) {
			Choice firstChoice = this.firstOpponent.makeChoice();
			Choice secondChoice = this.secondOpponent.makeChoice();
			this.firstOpponent.notifyOfResult(firstChoice, secondChoice);
			this.secondOpponent.notifyOfResult(secondChoice, firstChoice);
			this.firstPayoff += firstChoice.payoffAgainst(secondChoice);
			this.secondPayoff += secondChoice.payoffAgainst(firstChoice);
			if (this.isShowRoundResult) this.showRoundResult(firstChoice, secondChoice);
		}
		if (this.isShowMatchResult) this.showMatchResult();
	}
	
	public int getFirstPayoff() {
		return this.firstPayoff;
	}
	
	public int getSecondPayoff() {
		return this.secondPayoff;
	}
	
	private void showMatchResult() {
		System.out.println("" + firstPayoff + ":" + secondPayoff + " at "
				+ getStrategyName(this.firstOpponent) + " - "
				+ getStrategyName(secondOpponent));
	}
	
	private void showRoundResult(Choice firstChoice, Choice secondChoice) {
		String result;
		if (firstChoice == Choice.COOPERATE) {
			if (secondChoice == Choice.COOPERATE) {
				result = "GOOD DRAW";
			} else {
				result = "LOSS";
			}
		} else {
			if (secondChoice == Choice.COOPERATE) {
				result = "WIN";
			} else {
				result = "BAD DRAW";
			}
		}
		System.out.println(result + ": " + firstChoice.name() + " - "
					+ secondChoice.name());
	}
	
	private String getStrategyName(Strategy s) {
		return s.getClass().getSimpleName();
	}
}
