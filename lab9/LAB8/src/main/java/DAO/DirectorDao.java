package DAO;

import TABLES.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorDao implements Dao<Director> {
    private Connection con;

    public DirectorDao(Connection con) {
        this.con = con;
    }
@Override
    public void add(Director director) throws SQLException {
        String query = "insert into director values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, director.getId());
        ps.setString(2, director.getName());
        ps.executeUpdate();
    }
@Override
    public Director get(int id) throws SQLException {

        String query = "select * from director where id= ?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        Director director = new Director();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            director.setName(rs.getString("name"));
        }

        if (check) {
            return director;
        } else
            return null;
    }

}
