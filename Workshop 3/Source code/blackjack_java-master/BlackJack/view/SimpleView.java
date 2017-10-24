package BlackJack.view;

public class SimpleView extends Observer implements IView {
	
	public void event() {
		System.out.println("EVENT YES");
	}
	
	public void DisplayWelcomeMessage() {
		for (int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}
	
	private int GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public IView.Intent getIntent() {
		int userInput = this.GetInput();
		switch(userInput) {
			case 'p':
				return Intent.NewGame;
			case 'h':
				return Intent.Hit;
			case 's':
				return Intent.Stand;
			case 'q':
				return Intent.Quit;
			default:
				return null;
		}
	}
	
	
	public void DisplayCard(BlackJack.model.Card a_card) {
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}
	
	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}
	
	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}
	
	private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Has: ");
		for (BlackJack.model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}
	
	public void DisplayGameOver(boolean a_dealerIsWinner) {
		System.out.println("GameOver: ");
		if (a_dealerIsWinner) {
			System.out.println("Dealer Won!");
		} else {
			System.out.println("You Won!");
		}
		
	}
}
