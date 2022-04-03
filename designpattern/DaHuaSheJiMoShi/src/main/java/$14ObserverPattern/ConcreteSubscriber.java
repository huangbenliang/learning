package $14ObserverPattern;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

public class ConcreteSubscriber extends Subscriber {
	private final String name;
	@Getter
	@Setter
	private ConcretePublisher concretePublisher;

	public ConcreteSubscriber(ConcretePublisher concretePublisher, String name) {
		this.concretePublisher = concretePublisher;
		this.name = name;
	}

	@Override
	public void update() {
		String publisherState = concretePublisher.getPublisherState();
		System.out.println(MessageFormat.format("观察者{0}的状态是{1}", name, publisherState));
	}
}
