package $24ChainOfResponsibility;

import lombok.Setter;

import java.util.function.Predicate;

public abstract class Manager {
	protected String name;
	@Setter
	protected Manager superior;
	protected Predicate<Request> mapper;

	abstract public void handle(Request request);

	abstract void approve(Request request);

	abstract void decline(Request request);

	abstract void sentToSuperior(Request request);
}
