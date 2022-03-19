package $01simpleFactory;

public class OperationDiv extends Operation {
	@Override
	public Double getResult() {
		if (get_numberB() == 0) {
			throw new ArithmeticException("除数不能为0");
		}
		return get_numberA() / get_numberB();
	}
}
