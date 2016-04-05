package prisonersDilemma;

public enum Choice {
	COOPERATE, DEFECT;
	
	private static final int OWN_EFFORT = 2;
	private static final int OWN_BENEFIT = 5;
	public int payoffAgainst(Choice c) {
		int result = 0;
		if (this == COOPERATE) result -= OWN_EFFORT;
		if (c == COOPERATE) result += OWN_BENEFIT;
		return result;
	}
	
	public static int maxResult() {
		return OWN_BENEFIT;
	}
	
	public static int warResult() {
		return 0;
	}
	
	public static int minResult() {
		return -OWN_EFFORT;
	}
}
