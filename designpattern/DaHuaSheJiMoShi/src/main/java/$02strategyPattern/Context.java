package $02strategyPattern;

public class Context {
	Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public Context(String type) {
		type = type.toUpperCase();
		switch (type) {
			case "A":
				this.strategy = new ConcreteStrategyA();
				break;
			case "B":
				this.strategy = new ConcreteStrategyB();
				break;
			case "C":
				this.strategy = new ConcreteStrategyC();
				break;
			default:
				throw new RuntimeException("unknow algorithm type:" + type);
		}
	}

	//半委托状态
	public void contextInterface() {
		strategy.algorithmInterface();
	}
}
