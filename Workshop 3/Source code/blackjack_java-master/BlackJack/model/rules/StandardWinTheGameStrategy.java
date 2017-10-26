package BlackJack.model.rules;

public class StandardWinTheGameStrategy implements IWinTheGameStrategy {
	public boolean isDealerWinner(int playerScore, int dealerScore, int maxScore) {
		if (playerScore > maxScore) {
			return true;
		} else if (dealerScore > maxScore) {
			return false;
		} else if (dealerScore == playerScore) {
			return false;
		}
		return dealerScore > playerScore;
	}
}
