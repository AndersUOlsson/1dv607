package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.Card;
import BlackJack.model.Card.Value;

public class PlayGame {

  public boolean Play(Game a_game, IView a_view) {
    a_view.DisplayWelcomeMessage();
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    IView.Intent input = a_view.getIntent();
    
    if (input == IView.Intent.NewGame)
    {
        a_game.NewGame();
    }
    else if (input == IView.Intent.Hit)
    {
        a_game.Hit();
    }
    else if (input == IView.Intent.Stand)
    {
        a_game.Stand();
    }

    return input != IView.Intent.Quit;
  }
}