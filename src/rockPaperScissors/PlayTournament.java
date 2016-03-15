package rockPaperScissors;

import rockPaperScissors.strategies.*;
import rockPaperScissors.strategies.m1ngXu.*;
import rockPaperScissors.strategies.phoyh.*;

public class PlayTournament {

	private static Strategy[] STRATEGIES = new Strategy[] {
		new AlwaysPaper(),
		new AlwaysScissors(),
		new AlwaysRock(),
		new AlwaysRandom(),
		new M1ngXUA(),
		new PhoyhKillA(),
		new M1ngXUB(),
		new SequenceMemorizer()
	};
	
	public static void main(String[] args) {
		Tournament t = new Tournament(3, 100, STRATEGIES);
		t.play();
		System.out.println("\n" + t);
	}

}
