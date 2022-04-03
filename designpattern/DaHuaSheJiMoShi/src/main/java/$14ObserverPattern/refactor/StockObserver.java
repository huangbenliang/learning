package $14ObserverPattern.refactor;


import java.text.MessageFormat;

public class StockObserver {
	private String name;
	private Subject sub;

	public StockObserver(String name, Subject sub) {
		this.name = name;
		this.sub = sub;
	}

	public void closeStockMarket() {
		System.out.println(MessageFormat.format("{0} {1}关闭股票行情,继续工作!", sub.getSubjectState(), name));
	}
}
