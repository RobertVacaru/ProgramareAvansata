package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @GetMapping("/persons")
    public List<Person> getPersons() throws SQLException {
        Connection conn = Singleton.getCon();
        String query = "SELECT * from person";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        List<Person> lst = new ArrayList<>();
        while (rs.next()) {
            lst.add(new Person(rs.getString("name")));

        }
        rs.close();
        return lst;
    }
    @GetMapping("/persons")
    public String addPersons(@RequestBody Person person) throws SQLException {
        Connection conn = Singleton.getCon();
        String query = "INSERT into person (name) values (?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1,person.getName());
         boolean rs= preparedStatement.execute();
         if(rs)
             return "It works";
         else return "It doesn't work";

    }

}
