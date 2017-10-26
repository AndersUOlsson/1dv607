package BlackJack.model.rules;

public interface IWinTheGameStrategy {
	
	public boolean isDealerWinner(int playerScore, int dealerScore, int maxScore);

}
