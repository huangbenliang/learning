package $14ObserverPattern.refactor;

import java.util.ArrayList;
import java.util.List;

public class Boss extends Subject {


	private List<EventHandlerFunction> list = new ArrayList<>();

	@Override
	public void notifyObserver() {
		list.forEach(EventHandlerFunction::execute);
	}

	public void add(EventHandlerFunction mapper) {
		list.add(mapper);
	}
}
