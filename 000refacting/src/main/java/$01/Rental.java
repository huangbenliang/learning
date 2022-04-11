package $01;

import lombok.Getter;

@Getter
public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

    /**
     * 获取总金额
     * @return
     */
    double getCharge() {
        double result=0;
        //determine amounts for aRental line
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
