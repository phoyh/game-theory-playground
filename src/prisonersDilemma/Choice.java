package prisonersDilemma;

public enum Choice {
	COOPERATE, DEFECT;
	
	private final int OWN_EFFORT = 2;
	private final int OWN_BENEFIT = 5;
	public int payoffAgainst(Choice c) {
		int result = 0;
		if (this == COOPERATE) result -= OWN_EFFORT;
		if (c == COOPERATE) result += OWN_BENEFIT;
		return result;
	}
}
