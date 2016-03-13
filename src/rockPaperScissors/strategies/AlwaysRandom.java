package rockPaperScissors.strategies;

import java.util.Random;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;

public class AlwaysRandom implements Strategy {
	Random r = new Random();

	@Override
	public void initialize() {
	}

	@Override
	public Choice makeChoice() {
		int i = r.nextInt(3);
		Choice c;
		switch (i) {
			case 0:
				c = Choice.PAPER;
				break;
			case 1:
				c = Choice.ROCK;
				break;
			default:
				c = Choice.SCISSORS;
		}
		return c;
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
	}

}
