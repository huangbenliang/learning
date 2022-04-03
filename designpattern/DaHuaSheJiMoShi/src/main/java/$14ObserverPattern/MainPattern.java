package $14ObserverPattern;

public class MainPattern {
	public static void main(String[] args) {
		ConcretePublisher publisher = new ConcretePublisher();
		publisher.attach(new ConcreteSubscriber(publisher, "X"));
		publisher.attach(new ConcreteSubscriber(publisher, "Y"));
		publisher.attach(new ConcreteSubscriber(publisher, "Z"));
		publisher.setPublisherState("ABC");
		publisher.notifySubscriber();
	}
}
