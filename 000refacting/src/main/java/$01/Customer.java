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
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for" + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "Your earned " + getFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
