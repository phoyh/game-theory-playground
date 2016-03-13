package rockPaperScissors;


public class Match {
	Strategy firstOpponent;
	Strategy secondOpponent;
	int numberOfRounds;
	int firstWins;
	int secondWins;
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
		this.firstWins = 0;
		this.secondWins = 0;
		if (this.isShowRoundResult) this.showMatchResult();
		for (int i = 0; i < numberOfRounds; i++) {
			Choice firstChoice = this.firstOpponent.makeChoice();
			Choice secondChoice = this.secondOpponent.makeChoice();
			this.firstOpponent.notifyOfResult(firstChoice, secondChoice);
			this.secondOpponent.notifyOfResult(secondChoice, firstChoice);
			if (firstChoice.winsAgainst(secondChoice)) {
				this.firstWins++;
			}
			if (secondChoice.winsAgainst(firstChoice)) {
				this.secondWins++;
			}
			if (this.isShowRoundResult) this.showRoundResult(firstChoice, secondChoice);
		}
		if (this.isShowMatchResult) this.showMatchResult();
	}
	
	public double getFirstWinPercentage() {
		return .5 + ((double) (this.firstWins - this.secondWins)) / 2 / this.numberOfRounds;
	}
	
	public double getSecondWinPercentage() {
		return 1.0 - this.getFirstWinPercentage();
	}
	
	private void showMatchResult() {
		System.out.println("" + firstWins + ":" + secondWins + " at "
				+ getStrategyName(this.firstOpponent) + " - "
				+ getStrategyName(secondOpponent));
	}
	
	private void showRoundResult(Choice firstChoice, Choice secondChoice) {
		String result = "DRAW";
		if (firstChoice.winsAgainst(secondChoice)) result = "WIN";
		if (secondChoice.winsAgainst(firstChoice)) result = "LOSS";
		System.out.println(result + ": " + firstChoice.name() + " - "
					+ secondChoice.name());
	}
	
	private String getStrategyName(Strategy s) {
		return s.getClass().getSimpleName();
	}
}
