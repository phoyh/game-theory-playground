package prisonersDilemma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prisonersDilemma.strategies.AlwaysCooperate;

public class Population {
	private class PopulationType implements Comparable<PopulationType> {
		Class<? extends Strategy> c;
		int memberNumber = 0;
		double lastAverage = Double.MIN_VALUE;
		public String toString() {
			String numStr = "    " + memberNumber;
			return "" + numStr.substring(numStr.length() - 5) + " "
					+ (c.getSimpleName() + "..........................").substring(0, 30)
					+ " " + ((lastAverage == Double.MIN_VALUE) ? "" : lastAverage);
		}
		@Override
		public int compareTo(PopulationType other) {
			if (memberNumber < other.memberNumber) return 1;
			if (memberNumber > other.memberNumber) return -1;
			return 0;
		}
	}
	
	List<PopulationType> population;
	int numberOfMatchesAmongEachParticipantPair;
	int numberOfRoundsPerMatch;
	int maxReproduction;
	int maxPopulationSize;
	
	public Population(int size, int maxPopulationSize, int maxReproduction,
			Strategy[] startStrategies,
			int numberOfMatchesAmongEachParticipantPair,
			int numberOfRoundsPerMatch) {
		this.maxReproduction = maxReproduction;
		this.maxPopulationSize = maxPopulationSize;
		this.numberOfMatchesAmongEachParticipantPair = numberOfMatchesAmongEachParticipantPair;
		this.numberOfRoundsPerMatch = numberOfRoundsPerMatch;
		population = new ArrayList<PopulationType>();
		for (int i = 0; i < startStrategies.length; i++) {
			final Strategy s = startStrategies[i];
			final int n;
			if (s.getClass().equals(AlwaysCooperate.class)) {
				n = size - startStrategies.length + 1;
			} else {
				n = 1;
			}
			population.add(new PopulationType() {{
				this.c = s.getClass();
				this.memberNumber = n;
			}});
		}
	}

	public void tick(boolean isShowPopulation) {
		Tournament t = new Tournament(numberOfMatchesAmongEachParticipantPair,
				numberOfRoundsPerMatch, false, getPopulationMemberStrategies());
		t.play();
		for (PopulationType pt: population) {
			pt.lastAverage = 0;
		}
		for (TournamentParticipant tp: t.getParticipants()) {
			PopulationType pt = getPopulationType(tp.getStrategy());
			pt.lastAverage += tp.getAveragePayoff()
					/ pt.memberNumber
					/ numberOfRoundsPerMatch;
		}
		if (isShowPopulation) {
			System.out.println(this);
		}
		//min: level for 0 reproduction
		double reproduceMin = ((double) numberOfRoundsPerMatch)
				* Choice.warResult();
		//max: level for max reproduction
		double reproduceMax = ((double) numberOfRoundsPerMatch)
				* Choice.maxResult();
		for (TournamentParticipant tp: t.getParticipants()) {
			PopulationType pt = getPopulationType(tp.getStrategy());
			pt.memberNumber--;
			if (tp.getAveragePayoff() >= reproduceMin) {
				pt.memberNumber += ((double) maxReproduction)
						* (tp.getAveragePayoff() - reproduceMin)
						/ (reproduceMax - reproduceMin);
			}
		}
		resizePopulation();
	}
	
	private void resizePopulation() {
		if (getSize() < maxPopulationSize) {
			return;
		}
		double factor = ((double) maxPopulationSize) / getSize();
		for (PopulationType pt: population) {
			pt.memberNumber = (int) (factor * pt.memberNumber);
		}
	}

	private PopulationType getPopulationType(Strategy s) {
		for (PopulationType pt: population) {
			if (pt.c.equals(s.getClass())) {
				return pt;
			}
		}
		return null;
	}

	private Strategy[] getPopulationMemberStrategies() {
		Strategy[] ss = new Strategy[getSize()];
		int index = 0;
		for (PopulationType pt: population) {
			for (int i = 0; i < pt.memberNumber; i++) {
				try {
					ss[index++] = pt.c.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ss;
	}
	
	public String toString() {
		Collections.sort(population);
		String ret = "Current population (total " + getSize() + "):";
		for (PopulationType pt: population) {
			ret += "\n" + pt;
		}
		return ret;
	}
	
	public int getSize() {
		int ret = 0;
		for (PopulationType pt: population) {
			ret += pt.memberNumber;
		}
		return ret;
	}
}
