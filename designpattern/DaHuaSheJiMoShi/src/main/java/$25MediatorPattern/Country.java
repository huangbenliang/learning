package $25MediatorPattern;

public abstract class Country {
	protected UnitedNations mediator;

	public Country(UnitedNations mediator) {
		this.mediator = mediator;
	}
}
