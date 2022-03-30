package $07ProxyPattern.$13builderPattern;

public class ConcreteBuilder2 extends Builder {
	Product product = new Product();

	@Override
	public void buildPartA() {
		product.add("部件X");
	}

	@Override
	public void buildPartB() {
		product.add("部件Y");
	}

	@Override
	public Product getResult() {
		return product;
	}
}
