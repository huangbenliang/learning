package $06decoratorPattern;

import lombok.Setter;

public class Decorator extends Component {
	@Setter
	protected Component component;

	@Override
	public void operate() {
		if (component != null) {
			component.operate();
		}
	}
}
