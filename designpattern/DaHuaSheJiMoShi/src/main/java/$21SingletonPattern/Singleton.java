package $21SingletonPattern;

import java.util.Optional;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {

		return Optional.ofNullable(instance).orElseGet(() -> {
			instance = new Singleton();
			return instance;
		});
/*
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;*/
	}

}
