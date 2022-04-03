package $14ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
	List<Subscriber> subscribers = new ArrayList<>();

	public void attach(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void detech(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	public void notifySubscriber() {
		subscribers.forEach(Subscriber::update);
	}
}
