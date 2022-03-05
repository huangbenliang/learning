package _08reuse;

class Insect {
	private static int staticBlock;
	private static final int x1 = printInit("static Insect.x1 initialized");

	//静态块
	static {
		System.out.println("Insert static block.staticBlock=" + staticBlock);
		staticBlock = 9;
		System.out.println("Insert static block.staticBlock=" + staticBlock);
		System.out.println(x1);
	}

	protected int j;
	private final int i = 9;
	private int instanceBlock;
	private final int k = printInit("Insect.k.initialized");
	//实例块
	{
		//System.out.println(k);  在这里写会报错，因为k还没有声明。
	}

	{
		System.out.println("Insert instance block.instanceBlock=" + instanceBlock);
		instanceBlock = 9;
		System.out.println("Insert instance block.instanceBlock=" + instanceBlock);
		System.out.println(k);

	}

	Insect() {
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}

	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

public class Beetle extends Insect {
	private static final int x2 = printInit("static Beetle.x2 initialized");
	private final int k = printInit("Beetle.k.initialized");

	public Beetle() {
		System.out.println("k = " + k);
		System.out.println("j = " + j);
	}

	public static void main(String[] args) {
		System.out.println("Beetle constructor");
		Beetle b = new Beetle();
	}
}
