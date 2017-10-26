package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program {
	
	public static void main(String[] a_args) {
		IView v = new SimpleView(); //new SwedishView();
		Game g = new Game();
		PlayGame ctrl = new PlayGame(g, v);
		while (ctrl.Play());
	}
}