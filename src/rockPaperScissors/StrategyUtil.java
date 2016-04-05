package rockPaperScissors;

import java.util.Random;
import java.util.Set;

import org.reflections.Reflections;

public class StrategyUtil {
	public static Strategy getRandomStrategy() {
		Strategy[] ss = getStrategies();
		Random r = new Random();
		return ss[r.nextInt(ss.length)];
	}
	
	public static Strategy[] getStrategies() {
		Reflections reflections = new Reflections("rockPaperScissors.strategies");    
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
