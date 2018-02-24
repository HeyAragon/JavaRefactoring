/**
 * Author: aragon
 * Description:
 * Date:created at 上午 11:32${Date}
 */
public class Test {

    public static void main(String[] args) {
        Customer customer = new Customer("张三");
        Movie movie_1 = new Movie("这个杀手不太冷", Movie.REGULAR);
        Movie movie_2 = new Movie("杀手47啊", Movie.CHILDRENS);
        Movie movie_3 = new Movie("黑豹", Movie.NEW_RELEASE);
        Rental rental_1 = new Rental(movie_1, 3);
        Rental rental_2 = new Rental(movie_2, 1);
        Rental rental_3 = new Rental(movie_3, 7);
        customer.addRental(rental_1);
        customer.addRental(rental_2);
        customer.addRental(rental_3);
        System.out.printf(customer.statement());
    }
}
