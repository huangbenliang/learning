package $14ObserverPattern.refactor;

import lombok.Data;

@Data
public abstract class Subject {
	public abstract void notifyObserver();

	private String subjectState;
}
