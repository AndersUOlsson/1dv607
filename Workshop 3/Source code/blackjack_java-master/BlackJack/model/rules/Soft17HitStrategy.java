package BlackJack.model.rules;

import java.util.Iterator;

import BlackJack.model.Card;
import BlackJack.model.Card.Value;
import BlackJack.model.Player;

public class Soft17HitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;
	
	public boolean DoHit(Player a_dealer) {
		
		boolean rule = true;
		if(a_dealer.CalcScore() >= 21)
			rule = false;
		//if(a_dealer.CalcScore() >= g_hitLimit)
		if(a_dealer.CalcScore() == this.g_hitLimit){
		
			Iterator<Card> iter = a_dealer.GetHand().iterator();
			while(iter.hasNext()) {
				Card temp = iter.next();
				
				if(temp.GetValue() == Value.Ace)
					rule = true;
				
				/*if(temp.GetValue() != Value.Ace ) {
					rule = false;
				}*/
			}
		}
		return rule;
	}
}
