package $01simpleFactory;

public class OperationSub extends Operation{
	@Override
	public Double getResult() {
		return get_numberA()-get_numberB();
	}
}
