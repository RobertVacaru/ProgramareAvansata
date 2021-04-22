package DAO;

import TABLES.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MovieDao implements Dao<Movie>{
    private Connection con;

    public MovieDao(Connection con) {
        this.con = con;
    }
@Override
    public void add(Movie movie) throws SQLException {
        String query = "insert into movies values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, movie.getId());
        ps.setString(2, movie.getTitle());
        ps.setString(3, movie.getReleaseDate());
        ps.setInt(4, movie.getDuration());
        ps.setInt(5, movie.getScore());
        ps.executeUpdate();
    }
@Override
    public Movie get(int id) throws SQLException {

        String query = "select * from movies where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Movie movie = new Movie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            movie.setTitle(rs.getString("title"));
            movie.setReleaseDate(rs.getString("release_date"));
            movie.setDuration(rs.getInt("duration"));
            movie.setScore(rs.getInt("score"));
        }

        if (check) {
            return movie;
        } else
            return null;
    }

}