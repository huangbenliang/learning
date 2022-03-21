package $06decoratorPattern;

public class Main {
	public static void main(String[] args) {
		ConcreteComponent c=new ConcreteComponent();
		ConcreteDecoratorA d1 = new ConcreteDecoratorA();
		ConcreteDecoratorB d2 = new ConcreteDecoratorB();

		d2.setComponent(c);
		d1.setComponent(d2);
		d1.operate();
	}
}
