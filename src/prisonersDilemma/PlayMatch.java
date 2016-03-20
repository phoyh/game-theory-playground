package prisonersDilemma;

import prisonersDilemma.strategies.*;

public class PlayMatch {

	public static void main(String[] args) {
		Strategy a = new AlwaysCooperate();
		Strategy b = new AlwaysCooperate();
		Match m = new Match(a, b, 40, true, true);
		m.play();
		System.out.println("\nFirst payoff: " + m.getFirstPayoff());
		System.out.println("Second payoff: " + m.getSecondPayoff());
	}

}

