package $23CommandPattern;

public class Main {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		ConcreteCommand concreteCommand = new ConcreteCommand(receiver);

		Invoker invoker = new Invoker();
		invoker.setCommand(concreteCommand);
		invoker.executeCommand();
	}
}
