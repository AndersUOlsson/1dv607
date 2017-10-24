package BlackJack.model;

import BlackJack.model.rules.*;
import BlackJack.view.Observer;

import java.util.ArrayList;

public class Dealer extends Player {
	
	private Deck m_deck;
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public void notifyObservers() {
		for (Observer o : observers) {
			o.event();
		}
	}
	
	public Dealer(RulesFactory a_rulesFactory) {
		m_newGameRule = a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetSoft17Rule();
	}
	
	public void giveCardToPlayer(Player a_player) {
		giveCardToPlayer(a_player, true);
	}
	public void giveCardToPlayer(Player a_player, boolean a_shown) {
		Card c = m_deck.GetCard();
		c.Show(a_shown);
		a_player.DealCard(c);
	}
	
	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver()) {
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_newGameRule.NewGame(m_deck, this, a_player);
		}
		return false;
	}
	
	public boolean Hit(Player a_player) {
		if (m_deck != null && a_player.CalcScore() < g_maxScore && ! IsGameOver()) {
			giveCardToPlayer(a_player);
			return true;
		}
		return false;
	}
	
	public boolean IsDealerWinner(Player a_player) {
		if (a_player.CalcScore() > g_maxScore) {
			return true;
		} else if (CalcScore() > g_maxScore) {
			return false;
		} else if (CalcScore() == a_player.CalcScore()) {
			return false;
		}
		return CalcScore() > a_player.CalcScore();
	}
	
	public boolean IsGameOver() {
		if (m_deck != null && m_hitRule.DoHit(this) != true) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is when the player wants to stand.
	 *
	 * @return true
	 */
	public boolean stand() {
		
		Card c;
		
		if (this.m_deck != null) {
			this.ShowHand();
			while (this.m_hitRule.DoHit(this)) {
				giveCardToPlayer(this);
			}
		}
		return true;
	}
}