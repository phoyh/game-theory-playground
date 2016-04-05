package prisonersDilemma;


public class PlayTournament {

	public static void main(String[] args) {
		
		Tournament t = new Tournament(3, 200, true, StrategyUtil.getStrategies());
		t.play();
		System.out.println("\n" + t);
	}

}
