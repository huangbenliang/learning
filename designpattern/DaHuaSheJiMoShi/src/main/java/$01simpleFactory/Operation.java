package $01simpleFactory;

import lombok.Data;

@Data
public abstract class Operation {
	private Double _numberA;
	private Double _numberB;

	abstract public Double getResult();
}
