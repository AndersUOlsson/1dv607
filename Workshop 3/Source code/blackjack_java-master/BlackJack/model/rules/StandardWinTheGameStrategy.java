package BlackJack.model.rules;

public class StandardWinTheGameStrategy implements IWinTheGameStrategy {
	public boolean isDealerWinner(int playerScore, int dealerScore, int maxScore) {
		// if player is thick, dealer wins
		if (playerScore > maxScore) {
			return true;
			
		// if dealer is thick, player wins
		} else if (dealerScore > maxScore) {
			return false;
			
		// if tied, player wins. we are nice like that
		} else if (dealerScore == playerScore) {
			return false;
		}
		
		// else, dealer wins if they have a higher score than the player.
		return dealerScore > playerScore;
	}
}
