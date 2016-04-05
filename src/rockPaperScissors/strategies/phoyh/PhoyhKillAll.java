package rockPaperScissors.strategies.phoyh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rockPaperScissors.Choice;
import rockPaperScissors.Strategy;
import rockPaperScissors.StrategyUtil;
import rockPaperScissors.strategies.AlwaysRandom;

public class PhoyhKillAll implements Strategy {

	List<Strategy> possibleStrategies;
	Choice hisLastExpectedChoice;
	Strategy lastExpectedStrategy;
	Strategy alwaysRandom;
	
	@Override
	public void initialize() {
		possibleStrategies = new ArrayList<Strategy>();
		for (Strategy s: StrategyUtil.getStrategies()) {
			Class<? extends Strategy> sc = s.getClass();
			if (!sc.equals(this.getClass())) {
				if (sc.equals(AlwaysRandom.class)) {
					alwaysRandom = s;
				} else {
					possibleStrategies.add(s);
				}
				s.initialize();
			}
		}
	}

	@Override
	public Choice makeChoice() {
		if (possibleStrategies.size() == 0) {
			lastExpectedStrategy = alwaysRandom;
		} else {
			Random r = new Random();
			lastExpectedStrategy = possibleStrategies.get(r.nextInt(possibleStrategies.size()));
		}
		hisLastExpectedChoice = lastExpectedStrategy.makeChoice();
		switch (hisLastExpectedChoice) {
			case ROCK:
				return Choice.PAPER;
			case PAPER:
				return Choice.SCISSORS;
			default:
				return Choice.ROCK;
		}
	}

	@Override
	public void notifyOfResult(Choice myChoice, Choice hisChoice) {
		if (!hisChoice.equals(hisLastExpectedChoice)) {
			possibleStrategies.remove(lastExpectedStrategy);
		}
		for (Strategy s: possibleStrategies) {
			s.notifyOfResult(hisChoice, myChoice);
		}
	}

}
