package $06decoratorPattern;

public class ConcreteDecoratorB extends Decorator {
	private void addedMethod() {
		System.out.println("ConcreteDecoratorB.addedMethod");
	}


	@Override
	public void operate() {
		super.operate();
		addedMethod();
		System.out.println("具体装饰对象B的操作:addedMethod执行完毕");
	}
}
