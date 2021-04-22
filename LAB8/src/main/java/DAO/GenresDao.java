package DAO;

import TABLES.Genres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GenresDao implements Dao<Genres>{
    private Connection con;

    public GenresDao(Connection con) {
        this.con = con;
    }
@Override
    public void add(Genres genre) throws SQLException {
        String query = "insert into genres values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, genre.getId());
        ps.setString(2, genre.getName());
        ps.executeUpdate();
    }
@Override
    public Genres get(int id) throws SQLException {

        String query = "select * from genres where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Genres genre = new Genres();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            genre.setName(rs.getString("name"));
        }

        if (check) {
            return genre;
        } else
            return null;
    }


}