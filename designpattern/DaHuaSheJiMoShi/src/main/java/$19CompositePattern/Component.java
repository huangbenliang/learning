package $19CompositePattern;

public abstract class Component {
	protected String name;

	public Component(String name) {
		this.name = name;
	}

	public abstract void add(Component component);

	public abstract void remove(Component component);

	public abstract void display(int depth);

	public String getHyphen(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append('-');
		}
		String hyphen = sb.toString();
		return hyphen;
	}

}
