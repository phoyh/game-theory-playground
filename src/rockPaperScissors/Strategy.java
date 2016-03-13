package rockPaperScissors;

public interface Strategy {
	public void initialize();
	public Choice makeChoice();
	public void notifyOfResult(Choice myChoice, Choice hisChoice);
}
