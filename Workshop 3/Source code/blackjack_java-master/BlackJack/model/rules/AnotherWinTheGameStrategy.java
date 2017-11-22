package BlackJack.model.rules;

public class AnotherWinTheGameStrategy implements IWinTheGameStrategy {
	public boolean isDealerWinner(int playerScore, int dealerScore, int maxScore) {
		
		if (playerScore > maxScore) {
			return true;
		} else if (dealerScore > maxScore) {
			return false;
		} else if (dealerScore == playerScore) {
			return true; // <---- changed so the dealer wins on equal score, which they don't in our StandardWinTheGameStrategy.
		}
		return dealerScore > playerScore;
	}
}
