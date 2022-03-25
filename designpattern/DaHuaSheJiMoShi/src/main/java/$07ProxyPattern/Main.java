package $07ProxyPattern;

public class Main {
	public static void main(String[] args) {
		SchoolGirl mm = new SchoolGirl();
		mm.setName("娇娇");

		Proxy proxy = new Proxy(mm);

		proxy.giveDolls();
		proxy.giveFlowers();
		proxy.giveChocolate();
	}
}
