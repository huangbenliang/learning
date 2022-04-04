package $19CompositePattern;

public class Leaf extends Component {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component component) {
		System.out.println("Cannot add to a leaf.");
	}

	@Override
	public void remove(Component component) {
		System.out.println("Cannot remove from a leaf.");
	}

	@Override
	public void display(int depth) {
		String hyphen = getHyphen(depth);
		System.out.println(hyphen + name);
	}


}
