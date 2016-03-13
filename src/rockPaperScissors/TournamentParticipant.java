package rockPaperScissors;

import java.text.DecimalFormat;

public class TournamentParticipant implements Comparable<TournamentParticipant> {
	Strategy strategy;
	int playedMatches = 0;
	double averageWinPercentage = 0.0;
	
	public TournamentParticipant(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public void notifyOfMatchResult(double ownWinPercentage) {
		averageWinPercentage = (playedMatches * averageWinPercentage + ownWinPercentage)
				/ (playedMatches + 1);
		playedMatches++;
	}

	@Override
	public int compareTo(TournamentParticipant otherParticipant) {
		if (this.averageWinPercentage < otherParticipant.averageWinPercentage) return 1;
		if (this.averageWinPercentage > otherParticipant.averageWinPercentage) return -1;
		return 0;
	}
	
	public String toString() {
		String str = new DecimalFormat("  #0.00").format(averageWinPercentage * 100);
		str = str.substring(str.length() - 6);
		str += " % by " + this.strategy.getClass().getSimpleName();
		return str;
	}
}
