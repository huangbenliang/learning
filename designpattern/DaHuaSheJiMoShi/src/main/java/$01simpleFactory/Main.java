package $01simpleFactory;

public class Main {
	public static void main(String[] args) {
		Operation operation;
		operation=OperationFactory.createOperate("/");
		operation.set_numberA(12d);
		operation.set_numberB(13d);
		Double result = operation.getResult();
		System.out.println("result = " + result);;

	}
}
