package $19CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
	private List<Component> children = new ArrayList<>();

	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		children.add(component);
	}

	@Override
	public void remove(Component component) {
		children.remove(component);
	}

	@Override
	public void display(int depth) {
		System.out.println(getHyphen(depth) + name);
		children.forEach(component -> component.display(depth + 2));
	}
}
