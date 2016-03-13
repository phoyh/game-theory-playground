package rockPaperScissors;

public enum Choice {
	ROCK, PAPER, SCISSORS;
	
	public boolean winsAgainst(Choice c) {
		return (this == ROCK && c == SCISSORS)
				|| (this == PAPER && c == ROCK)
				|| (this == SCISSORS && c == PAPER);
	}
}
