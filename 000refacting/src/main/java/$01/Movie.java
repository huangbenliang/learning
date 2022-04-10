package $01;

import lombok.Getter;
import lombok.Setter;

public class Movie {
	public static final int CHILDREN=2;
	public static final int REGULAR=0;
	public static final int NEW_RELEASE=1;

	@Getter
	private String title;
	@Setter
	@Getter
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title=title;
		this.priceCode=priceCode;
	}

}
