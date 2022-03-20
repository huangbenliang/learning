package $02strategyPattern;

public class Main {
	public static void main(String[] args) {
		Context context;

		context=new Context("A");
		context.contextInterface();

		context=new Context("b");
		context.contextInterface();

		context=new Context("d");
		context.contextInterface();

	}
}
