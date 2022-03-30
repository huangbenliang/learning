package $07ProxyPattern.$13builderPattern;

public class Director {
	public void construct(Builder builder) {
		builder.buildPartA();
		builder.buildPartB();
	}
}
