package $14ObserverPattern;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Secretary {
	private final List<StockObserver> observers = new ArrayList<>();
	@Getter
	@Setter
	private String action;

	public void attach(StockObserver observer) {
		observers.add(observer);
	}

	public void notifyObserver() {
		observers.forEach(StockObserver::update);
	}
}
