package $24ChainOfResponsibility;

public class Main {
	public static void main(String[] args) {
		ConcreteManager manager = new ConcreteManager("经理", request -> Request.RequestEnum.VACATE == request.getRequestType() && request.getNumber() <= 2);
		ConcreteManager major = new ConcreteManager("总监", request -> Request.RequestEnum.VACATE == request.getRequestType() && request.getNumber() <= 5);
		GeneralManager generalManager = new GeneralManager("总经理");
		manager.setSuperior(major);
		major.setSuperior(generalManager);

		Request xiaoCai = new Request("小菜", Request.RequestEnum.VACATE, 2d);
		manager.handle(xiaoCai);
		Request xiaoLi = new Request("小李", Request.RequestEnum.VACATE, 5d);
		manager.handle(xiaoLi);
		Request xiaoHua = new Request("小华", Request.RequestEnum.RAISE_SALARY, 200d);
		manager.handle(xiaoHua);
		Request xiaoHuang = new Request("小黄", Request.RequestEnum.RAISE_SALARY, 2000d);
		manager.handle(xiaoHuang);
	}
}
