package BlackJack.model;

/**
 * Created by Mushra on 2017-10-24.
 */
public abstract class Observer {
	protected Dealer dealer;
	public abstract void event();
}
