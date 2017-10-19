package BlackJack.model.rules;

import BlackJack.model.Player;

public class Soft17HitStrategy implements ISoft17HitStrategy
{	
	    private final int g_hitLimit = 17;
	 
	    public boolean DoSoft17Hit(Player a_dealer) {
	      return a_dealer.CalcScore() == g_hitLimit;  
	    }
	
}
