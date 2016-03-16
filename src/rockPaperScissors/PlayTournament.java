package rockPaperScissors;

import java.util.Set;

import org.reflections.Reflections;

public class PlayTournament {

	public static void main(String[] args) {
		
		Tournament t = new Tournament(3, 100, getStrategies());
		t.play();
		System.out.println("\n" + t);
	}

	private static Strategy[] getStrategies() {
		Reflections reflections = new Reflections("rockPaperScissors");    
		Set<Class<? extends Strategy>> strategyClasses =
				reflections.getSubTypesOf(Strategy.class);
		Strategy[] result = new Strategy[strategyClasses.size()];
		int index = 0;
		for (Class<? extends Strategy> c: strategyClasses) {
			try {
				result[index++] = c.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	};
}
