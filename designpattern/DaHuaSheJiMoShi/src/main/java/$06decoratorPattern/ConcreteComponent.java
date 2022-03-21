package $06decoratorPattern;

public class ConcreteComponent extends Component {

	@Override
	public void operate() {
		System.out.println("具体对象原来的操作...");
	}
}
