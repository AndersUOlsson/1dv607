package BlackJack.model.rules;

import java.util.Iterator;

import BlackJack.model.Card;
import BlackJack.model.Card.Value;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;
	
	public boolean DoHit(Player a_dealer) {
		
		// default case --> yeah take a card man
		boolean rule = true;
		
		// 18 or above --> no new card
		if(a_dealer.CalcScore() > this.g_hitLimit)
			rule = false;
		
		// 17 exactly --> new card if youve got an ace
		else if(a_dealer.CalcScore() == this.g_hitLimit){
			Iterator<Card> iter = a_dealer.GetHand().iterator();
			while(iter.hasNext()) {
				Card temp = iter.next();
				if(temp.GetValue() == Value.Ace) {
					rule = true;
					break;
				}
			}
		}
		return rule;
	}
}
