package rockPaperScissors;

import rockPaperScissors.strategies.m1ngXu.*;
import rockPaperScissors.strategies.phoyh.*;
import rockPaperScissors.strategies.*;

public class PlayMatch {

	public static void main(String[] args) {
		Strategy a = new M1ngXUWinner();
		Strategy b = new PhoyhKillAll();
		Match m = new Match(a, b, 100, true, true);
		m.play();
		System.out.println("\nFirst percentage: " + m.getFirstWinPercentage());
	}

}
