package $07ProxyPattern;

public class Proxy implements IGiveGift {
	//这里改成接口
	IGiveGift gg;

	public Proxy(SchoolGirl schoolGirl) {
		gg = new Pursuit(schoolGirl);
	}

	@Override
	public void giveDolls() {
		gg.giveDolls();
	}

	@Override
	public void giveFlowers() {
		gg.giveFlowers();
	}

	@Override
	public void giveChocolate() {
		gg.giveChocolate();
	}
}
