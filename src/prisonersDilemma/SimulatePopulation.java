package prisonersDilemma;

public class SimulatePopulation {

	public static void main(String[] args) {
		Population p = new Population(40, 1000, 4, StrategyUtil.getStrategies(), 1, 100);
		int tickNumber = 0;
		while (p.getSize() > 0 && tickNumber < 40) {
			tickNumber++;
			System.out.println("\n********** TICK " + tickNumber + " *************");
			p.tick(true);
		}
	}

}
