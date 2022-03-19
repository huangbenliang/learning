package $01simpleFactory;

public class OperationAdd extends Operation{
	@Override
	public Double getResult() {
		return get_numberA()+get_numberB();
	}
}
