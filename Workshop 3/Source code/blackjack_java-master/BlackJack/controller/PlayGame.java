package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.Observer;
import BlackJack.model.Card;
import BlackJack.model.Card.Value;

import java.util.concurrent.TimeUnit;

public class PlayGame extends Observer {
	
	Game m_game;
	IView m_view;
	
	public PlayGame(Game a_game, IView a_view) {
		this.m_game = a_game;
		this.m_view = a_view;
		m_game.getDealer().addObserver(this);
	}
	
	public boolean Play() {
		m_view.DisplayWelcomeMessage();
		
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
		
		if (m_game.IsGameOver()) {
			m_view.DisplayGameOver(m_game.IsDealerWinner());
		}
		
		IView.Intent input = m_view.getIntent();
		
		if (input == IView.Intent.NewGame) {
			m_game.NewGame();
		} else if (input == IView.Intent.Hit) {
			m_game.Hit();
		} else if (input == IView.Intent.Stand) {
			m_game.Stand();
		}
		return input != IView.Intent.Quit;
	}
	
	public void event() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
		
		}
		m_view.fillRows();
		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
	}
}