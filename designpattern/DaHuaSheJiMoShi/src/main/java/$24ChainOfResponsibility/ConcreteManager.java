package $24ChainOfResponsibility;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.function.Predicate;

public class ConcreteManager extends Manager {

	public ConcreteManager(String name) {
		this.name = name;
	}

	public ConcreteManager(String name, Predicate<Request> mapper) {
		this.name = name;
		this.mapper = mapper;
	}

	public void handle(Request request) {
		if (mapper.test(request)) {
			approve(request);
		} else {
			sentToSuperior(request);
		}
	}

	protected void approve(Request request) {
		printMessage(request, Request.RequestState.APPROVE);
	}

	protected void decline(Request request) {
		printMessage(request, Request.RequestState.DECLINE);
	}

	protected void sentToSuperior(Request request) {
		System.out.print(name + "送交给" + superior.name+"。");
		Optional.ofNullable(superior).ifPresent(s -> s.handle(request));
	}

	private void printMessage(Request request, Request.RequestState requestState) {
		//总经理0 拒绝1 了 小黄2 的 加薪3 请求 2,000(4) 元5.
		System.out.println(MessageFormat.format("{0}{1}了{2}的{3}请求{4}{5}.", name, requestState.getName(), request.getName(), request.getRequestType().getName(), request.getNumber(), request.getRequestType().getUnit()));
	}
}
