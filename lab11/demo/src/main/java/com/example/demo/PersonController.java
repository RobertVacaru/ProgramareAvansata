//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/Persons"})
public class PersonController {
    Connection connection = Singleton.getConnection();

    public PersonController() throws SQLException {
        List<Person> persoane = new ArrayList();
        String sql = "SELECT * FROM person ";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int friend = rs.getInt("numberOfFriends");
            persoane.add(new Person(name, id, friend));
        }

    }

    @GetMapping
    public List<Person> getPersons() throws SQLException {
        List<Person> persoane = new ArrayList();
        String sql = "SELECT * FROM person ";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int friend = rs.getInt("numberOfFriends");
            persoane.add(new Person(name, id, friend));
        }

        return persoane;
    }

    @GetMapping({"/{id}"})
    public List<Person> getPerson(@PathVariable("id") int id) throws SQLException {
        List<Person> persoane = new ArrayList();
        String sql = "SELECT * from person where id = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            int friend = rs.getInt("numberOfFriends");
            persoane.add(new Person(name, id, friend));
        }

        return persoane;
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestParam String name, int id) {
        try {
            String sql = "INSERT INTO person values(?,?,?)";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, 0);
            pstmt.execute();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return new ResponseEntity("Person created successfully", HttpStatus.CREATED);
    }


    @PutMapping({"/{id}"})
    public ResponseEntity<String> updatePerson(@PathVariable("id") int id, @RequestParam String name) throws SQLException {
        Person Person = this.findById(id);
        String sql = "UPDATE Person SET name=?  where id=?";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, id);
        pstmt.execute();
        if (Person == null)
            return new ResponseEntity("Person not found", HttpStatus.NOT_FOUND);
        else return new ResponseEntity("Person updated successfully", HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deletePerson(@PathVariable int id) throws SQLException {
        new Person();
        Person Person = this.findById(id);
        if (Person == null) {
            return new ResponseEntity("Person not found", HttpStatus.GONE);
        } else {
            int id1 = Person.getId();
            String sql = "DELETE from Person where id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id1);
            pstmt.execute();
            return new ResponseEntity("Person removed", HttpStatus.OK);
        }
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePerson(@RequestParam String name) throws SQLException {
        new Person();
        Person Person = this.findByName(name);
        if (Person == null) {
            return new ResponseEntity("Person not found", HttpStatus.GONE);
        } else {
            int id1 = Person.getId();
            String sql = "DELETE from Person where id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id1);
            pstmt.execute();
            return new ResponseEntity("Person removed", HttpStatus.OK);
        }
    }

    public Person findByName(String name) {
        Person pers = new Person();

        try {
            String sql = "SELECT * from Person where name = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                pers.setId(id);
                pers.setName(name);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return pers;
    }

    public Person findById(int id) {
        Person persoana = new Person();

        try {
            String sql = "SELECT * from Person where id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                persoana.setId(id);
                persoana.setName(name);
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }

        return persoana;
    }
}
