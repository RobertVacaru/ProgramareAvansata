import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class GenresDao implements Dao<Genres> {
    private Connection con;
    private final List<Genres> genres = new ArrayList<>();

    public GenresDao(Connection con) {
        this.con = con;
    }

    public void add(Genres genre) throws SQLException {
        String query="insert into genres values(?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,genre.getId());
        ps.setString(2,genre.getName());
        ps.executeUpdate();
    }
    @Override
    public Optional<Genres> get(long id) {
        return Optional.ofNullable(genres.get((int) id));
    }

    @Override
    public List<Genres> getAll() {
        return genres;
    }

    @Override
    public void save(Genres genre) {
        genres.add(genre);
    }

    @Override
    public void update(Genres genre, String[] params) {
        genre.setId(parseInt(params[0]));
        genre.setName(Objects.requireNonNull(
                params[1], "Name cannot be null"));
        this.genres.add(genre);
    }

    @Override
    public void delete(Genres movie) {
        genres.remove(movie);
    }

    public void printGenres() {
        System.out.println("GenresDao{" + "genres=");
        for (Genres genre : genres) System.out.println(genre.getId() + "-" + genre.getName());
        System.out.println("}");
    }
}