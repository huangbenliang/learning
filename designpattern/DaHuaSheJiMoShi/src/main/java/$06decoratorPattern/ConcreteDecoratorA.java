package $06decoratorPattern;

public class ConcreteDecoratorA extends Decorator {
	private String addedState;

	@Override
	public void operate() {
		super.operate();
		addedState="New state";
		System.out.println("具体装饰对象A的操作"+addedState);
	}
}
