package prisonersDilemma;

import java.text.DecimalFormat;

public class TournamentParticipant implements Comparable<TournamentParticipant> {
	Strategy strategy;
	int playedMatches = 0;
	int overallPayoff = 0;
	
	public TournamentParticipant(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public void notifyOfMatchResult(int ownPayoff) {
		this.overallPayoff += ownPayoff;
		playedMatches++;
	}

	@Override
	public int compareTo(TournamentParticipant otherParticipant) {
		if (this.getAveragePayoff() < otherParticipant.getAveragePayoff()) return 1;
		if (this.getAveragePayoff() > otherParticipant.getAveragePayoff()) return -1;
		return 0;
	}
	
	public double getAveragePayoff() {
		return ((double) this.overallPayoff) / playedMatches;
	}
	
	public String toString() {
		String str = new DecimalFormat("    #0.00").format(this.getAveragePayoff());
		str = str.substring(str.length() - 8);
		str += " by " + this.strategy.getClass().getSimpleName();
		return str;
	}

}
