import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);

    }

    public String getName() {
        return _name;
    }

    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            //determine amounts for each line
            switch (each.get_movie().get_priceCode()) {

                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.get_dayRented() > 2)
                        thisAmount += (each.get_dayRented() - 2) * 1.5;

                    break;

                case Movie.NEW_RELEASE:
                    thisAmount += each.get_dayRented() * 3;
                    break;

                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.get_dayRented() > 3)
                        thisAmount += (each.get_dayRented() - 3) * 1.5;

                    break;
            }

            //add frequent renter points
            frequentRenterPoints++;

            //add bonus for a two day new release rental
            if ((each.get_movie().get_priceCode() == Movie.NEW_RELEASE) &&
                    each.get_dayRented() > 1)
                frequentRenterPoints++;

            //show figures for this rental
            result.append("\t").append(each.get_movie().get_title()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;

        }

        //add footer lines
        result.append("Amount owed is").append("\t").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned").append("\t").append(String.valueOf(frequentRenterPoints)).append("\t").append("frequent renter points");



        return result.toString();
    }
}
