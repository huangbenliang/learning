package $26FlyWeight;

public class Main {
	public static void main(String[] args) {
		WebsiteFactory f = new WebsiteFactory();

		Website fx = f.getWebsiteCategory("产品展示");
		fx.use(new User("大鸟"));
		Website fy = f.getWebsiteCategory("产品展示");
		fy.use(new User("小菜"));
		Website f1 = f.getWebsiteCategory("博客");
		f1.use(new User("爸爸"));
		Website f2 = f.getWebsiteCategory("博客");
		f2.use(new User("妈妈"));

		System.out.println("示例总数:"+f.getWebsiteCount());

	}
}
