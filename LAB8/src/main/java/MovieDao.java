import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MovieDao implements Dao<Movie> {
    private Connection con;
    private final List<Movie> movies = new ArrayList<>();

    public MovieDao(Connection con) {
        this.con = con;
    }

    public void add(Movie movie) throws SQLException {
        String query="insert into movies values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,movie.getId());
        ps.setString(2,movie.getTitle());
        ps.setDate(3, (java.sql.Date) movie.getReleaseDate());
        ps.setInt(4,movie.getDuration());
        ps.setInt(5,movie.getScore());
        ps.executeUpdate();
    }
    @Override
    public Optional<Movie> get(long id) {
        return Optional.ofNullable(movies.get((int) id));
    }

    @Override
    public List<Movie> getAll() {
        return movies;
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void update(Movie movie, String[] params) throws ParseException {
        movie.setId(parseInt(params[0]));
        movie.setTitle(Objects.requireNonNull(
                params[1], "Title cannot be null"));
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(params[2]);
        movie.setReleaseDate(date1);
        movie.setId(parseInt(params[3]));
        movie.setId(parseInt(params[4]));
        movies.add(movie);
    }

    @Override
    public void delete(Movie movie) {
        movies.remove(movie);
    }

    public void printMovie() {
        System.out.println("MovieDao{" + "movies=");
        for (Movie movie : movies)
            System.out.println(movie.getId() + "-" + movie.getTitle() + "-" + movie.getReleaseDate() + "-" + movie.getDuration() + "-" + movie.getScore());
        System.out.println("}");
    }
}