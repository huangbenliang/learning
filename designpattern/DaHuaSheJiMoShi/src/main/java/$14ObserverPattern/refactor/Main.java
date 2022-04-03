package $14ObserverPattern.refactor;

public class Main {
	public static void main(String[] args) {
		Boss boss = new Boss();

		NBAObserver mrHuang = new NBAObserver("Mr.Huang", boss);
		StockObserver msFairy = new StockObserver("Ms.Fairy", boss);

		boss.add(mrHuang::closeLiveStream);
		boss.add(msFairy::closeStockMarket);

		boss.setSubjectState("我胡汉三又回来了!");

		boss.notifyObserver();
	}
}
