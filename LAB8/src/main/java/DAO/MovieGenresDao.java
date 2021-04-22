package DAO;

import TABLES.MovieGenres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieGenresDao implements Dao<MovieGenres> {
    private Connection con;

    public MovieGenresDao(Connection con) {
        this.con = con;
    }

    @Override
    public void add(MovieGenres movieGenres) throws SQLException {
        String query = "insert into moviegenres values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, movieGenres.getId());
        ps.setInt(2, movieGenres.getIdGenres());
        ps.setInt(3, movieGenres.getIdMovies());
        ps.executeUpdate();
    }

    @Override
    public MovieGenres get(int id) throws SQLException {

        String query = "select * from moviegenres where id= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        MovieGenres movieGenres = new MovieGenres();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            movieGenres.setIdGenres(rs.getInt("genresId"));
            movieGenres.setIdMovies(rs.getInt("moviesId"));
        }

        if (check) {
            return movieGenres;
        } else
            return null;
    }

}
