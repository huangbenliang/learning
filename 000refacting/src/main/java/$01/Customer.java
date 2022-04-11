package $01;

import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	@Getter
	private String name;
	private Vector<Rental> rentals = new Vector<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = this.rentals.elements();
		String result = "Rental Record for" + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = rentals.nextElement();

			thisAmount = each.getCharge();

			//add frequent renter points
			frequentRenterPoints++;
			//add bonus for  two day new release rental
			if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
				frequentRenterPoints++;
			}

			//show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "Your earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}

}
