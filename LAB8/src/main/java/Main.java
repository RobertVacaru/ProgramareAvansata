import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        Connection con;
        Singleton x = new Singleton();
        con= x.getInstance();
        Movie movie = new Movie(1, "Jumanji", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2000"), 200, 4);
        MovieDao movieDao = new MovieDao(con);
        movieDao.save(movie);
        Genres genre = new Genres(3, "Action");
        GenresDao genresDao = new GenresDao(con);
        genresDao.save(genre);
        genresDao.printGenres();
        genresDao.add(genre);
        movieDao.add(movie);
        movieDao.printMovie();
    }
}
