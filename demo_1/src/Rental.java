

public class Rental {

    private Movie _movie;
    private int _dayRented;

    public Rental(Movie _movie, int _dayRented) {
        this._movie = _movie;
        this._dayRented = _dayRented;
    }

    public Movie get_movie() {
        return _movie;
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public int get_dayRented() {
        return _dayRented;
    }

    public void set_dayRented(int _dayRented) {
        this._dayRented = _dayRented;
    }
}
