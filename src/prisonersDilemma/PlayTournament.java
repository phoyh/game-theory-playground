package prisonersDilemma;

import java.util.Set;

import org.reflections.Reflections;

public class PlayTournament {

	public static void main(String[] args) {
		
		Tournament t = new Tournament(3, 200, getStrategies(5));
		t.play();
		System.out.println("\n" + t);
	}

	private static Strategy[] getStrategies(int strategyMultitude) {
		Reflections reflections = new Reflections("prisonersDilemma");    
		Set<Class<? extends Strategy>> strategyClasses =
				reflections.getSubTypesOf(Strategy.class);
		Strategy[] result = new Strategy[strategyClasses.size() * strategyMultitude];
		int index = 0;
		for (Class<? extends Strategy> c: strategyClasses) {
			try {
				for (int i = 0; i < strategyMultitude; i++) {
					result[index++] = c.newInstance();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	};
}
