package $16StatePattern;

import lombok.Data;

@Data
public class Work {
	private State current;

	public Work() {
		current = new ForenoonState();
	}

	private double hour;
	private boolean finish = false;

	public void writeProgram() {
		current.writeProgram(this);
	}
}

