package $24ChainOfResponsibility;

public class GeneralManager extends ConcreteManager {
	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handle(Request request) {
		if (Request.RequestEnum.VACATE == request.getRequestType()) {
			approve(request);
		} else if (Request.RequestEnum.RAISE_SALARY == request.getRequestType() && request.getNumber() <= 500) {
			approve(request);
		} else if (Request.RequestEnum.RAISE_SALARY == request.getRequestType()) {
			decline(request);
		}
	}
}
