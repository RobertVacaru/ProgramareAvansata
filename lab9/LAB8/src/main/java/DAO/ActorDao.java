package DAO;

import TABLES.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorDao implements Dao<Actor> {
    private Connection con;

    public ActorDao(Connection con) {
        this.con = con;
    }
    @Override
    public void add(Actor actor) throws SQLException {
        String query = "insert into actor values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, actor.getId());
        ps.setString(2, actor.getName());
        ps.executeUpdate();
    }
     @Override
    public Actor get(int id) throws SQLException {

        String query = "select * from actor where id= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        Actor actor = new Actor();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            actor.setName(rs.getString("name"));
        }

        if (check) {
            return actor;
        } else
            return null;
    }

}
