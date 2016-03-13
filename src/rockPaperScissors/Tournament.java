package rockPaperScissors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tournament {
	List<TournamentParticipant> participants;
	List<Match> matches;
	List<TournamentParticipant> matchFirstOpponent;
	List<TournamentParticipant> matchSecondOpponent;
	
	public Tournament(int numberOfMatchesAmongEachParticipantPair,
			int numberOfRoundsPerMatch,
			Strategy[] strategies) {
		this.participants = new ArrayList<TournamentParticipant>();
		for (Strategy s: strategies) {
			this.participants.add(new TournamentParticipant(s));
		}
		prepareMatchSet(numberOfMatchesAmongEachParticipantPair,
				numberOfRoundsPerMatch);
	}
	
	private void prepareMatchSet(int numberOfMatchesAmongEachParticipantPair,
			int numberOfRoundsPerMatch) {
		matches = new ArrayList<Match>();
		matchFirstOpponent = new ArrayList<TournamentParticipant>();
		matchSecondOpponent = new ArrayList<TournamentParticipant>();
		for (TournamentParticipant p1: participants) {
			for (TournamentParticipant p2: participants) {
				if (participants.indexOf(p1) < participants.indexOf(p2)) {
					for (int i = 0; i < numberOfMatchesAmongEachParticipantPair; i++) {
						matches.add(new Match(
								p1.getStrategy(),
								p2.getStrategy(),
								numberOfRoundsPerMatch,
								false,
								true));
						matchFirstOpponent.add(p1);
						matchSecondOpponent.add(p2);
					}
				}
			}
		}
		Random r = new Random();
		for (int i = 0; i < matches.size(); i++) {
			int other = r.nextInt(matches.size());
			Collections.swap(matches, i, other);
			Collections.swap(matchFirstOpponent, i, other);
			Collections.swap(matchSecondOpponent, i, other);
		}
	}
	
	public void play() {
		for (int i = 0; i < matches.size(); i++) {
			Match m = matches.get(i);
			TournamentParticipant p1 = matchFirstOpponent.get(i);
			TournamentParticipant p2 = matchSecondOpponent.get(i);
			m.play();
			p1.notifyOfMatchResult(m.getFirstWinPercentage());
			p2.notifyOfMatchResult(m.getSecondWinPercentage());
		}
	}

	public String toString() {
		Collections.sort(participants);
		String str = "Standings:";
		int rank = 1;
		for (TournamentParticipant p: participants) {
			str += "\n" + (rank++) + ". " + p;
		}
		return str;
	}
}
