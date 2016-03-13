package rockPaperScissors;

import rockPaperScissors.strategies.m1ngXu.*;
import rockPaperScissors.strategies.phoyh.*;

public class PlayMatch {

	public static void main(String[] args) {
		Strategy a = new PhoyhKillA();
		Strategy b = new M1ngXUB();
		Match m = new Match(a, b, 10, true, true);
		m.play();
		System.out.println("\nFirst percentage: " + m.getFirstWinPercentage());
	}

}
