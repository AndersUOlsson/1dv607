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
}