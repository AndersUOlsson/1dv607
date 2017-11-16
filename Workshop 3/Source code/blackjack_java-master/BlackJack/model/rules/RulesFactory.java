package BlackJack.model.rules;

public class RulesFactory {
	
	public IHitStrategy GetHitRule() {
		return new BasicHitStrategy();
	}
	
	public INewGameStrategy GetNewGameRule() {
		return new AmericanNewGameStrategy();
	}
	
	public IHitStrategy GetSoft17Rule() {
		return new Soft17HitStrategy();
	}
	
	public IWinTheGameStrategy GetWinRule() {
		return new StandardWinTheGameStrategy();
	}
	public IWinTheGameStrategy GetAlternateWinRule() {
		return new AnotherWinTheGameStrategy();
	}
}