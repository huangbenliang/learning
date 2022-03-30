package $14ObserverPattern;

public class Main {
	public static void main(String[] args) {
		Secretary secretary = new Secretary();
		StockObserver MrYellow = new StockObserver("MrYellow", secretary);
		StockObserver MsXin = new StockObserver("MsXin", secretary);

		secretary.attach(MrYellow);
		secretary.attach(MsXin);

		secretary.setAction("老板回来了!");
		secretary.notifyObserver();
	}
}
