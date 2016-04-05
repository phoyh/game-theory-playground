package rockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayHumanMatch {

	public static void main(String[] args) {
		Strategy a = new HumanStrategy();
		Strategy b = a;
		while (a.getClass().equals(b.getClass())) {
			b = StrategyUtil.getRandomStrategy();
		}
		Match m = new Match(a, b, 10, false, true);
		m.play();
		System.out.println("\nFirst percentage: " + m.getFirstWinPercentage());
	}

	private static class HumanStrategy implements Strategy {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		@Override
		public void initialize() {
		}
		@Override
		public Choice makeChoice() {
	        System.out.print("\nYour choice of [R]OCK, [P]APER, [S]CISSORS: ");
	        char cChar = 'S';
	        try {
	        	String cStr = br.readLine();
	        	if (cStr.length() != 0) cChar = cStr.toUpperCase().charAt(0);
	        } catch (IOException e) {}
	        switch (cChar) {
	        	case 'R':
	        		return Choice.ROCK;
	        	case 'P':
	        		return Choice.PAPER;
	        	default:
	        		return Choice.SCISSORS;
	        }
		}
		@Override
		public void notifyOfResult(Choice myChoice, Choice hisChoice) {
			String result = "DRAW";
			if (myChoice.winsAgainst(hisChoice)) result = "WIN";
			if (hisChoice.winsAgainst(myChoice)) result = "LOSS";
			System.out.println("... " + result + ": " + myChoice.name() + " - "
						+ hisChoice.name());
		}
	}
	
}
