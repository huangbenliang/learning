package $07ProxyPattern;

public class RealSubject implements Subject  {
	@Override
	public void request() {
		System.out.println("真实的请求！");
	}
}
