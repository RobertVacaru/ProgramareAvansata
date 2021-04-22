import DAO.*;
import TABLES.Actor;
import TABLES.Director;
import TABLES.MovieGenres;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        Connection con;
        Singleton x = new Singleton();
        con = x.getInstance();
        MovieDao movieDao = new MovieDao(con);
        GenresDao genresDao = new GenresDao(con);
        DirectorDao directorDao = new DirectorDao(con);
        MovieGenresDao movieGenresDao = new MovieGenresDao(con);
        ActorDao actorDao = new ActorDao(con);
        TABLES.Movie movie = new TABLES.Movie(1, "Jumanji", "31/12/2000", 200, 4);
        TABLES.Genres genre = new TABLES.Genres(1, "Action");
        // movieDao.add(movie);
        // genresDao.add(genre);
        Director director = new Director(1, "Marcel");
        Actor actor = new Actor(1, "Ghita");
        MovieGenres movieGenres = new MovieGenres(1, 1, 1);
        //directorDao.add(director);
        // actorDao.add(actor);
        //movieGenresDao.add(movieGenres);
        System.out.println(directorDao.get(1).toString());
        System.out.println(actorDao.get(1).toString());
        System.out.println(genresDao.get(1).toString());
        System.out.println(movieDao.get(1).toString());
        System.out.println(movieGenresDao.get(1).toString());
    }
}
