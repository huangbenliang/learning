package $01simpleFactory;

public class OperationMul extends Operation {
	@Override
	public Double getResult() {
		return get_numberA() * get_numberB();
	}
}
