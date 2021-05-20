package com.example.demo.Relationship;

import com.example.demo.Person.Person;
import com.example.demo.Relationship.Relationship;
import com.example.demo.RestController.CustomNotFoundException;
import com.example.demo.Singleton;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping({"/Relationship"})
public class RelationshipController {
    Connection connection = Singleton.getConnection();

    public RelationshipController() throws SQLException {
        List<Relationship> relatii = new ArrayList();
        String sql = "SELECT * FROM relationship ";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int id1 = rs.getInt("id1");
            int id2 = rs.getInt("id2");
            relatii.add(new Relationship(id, id1, id2));
        }
    }

    @GetMapping
    public List<Relationship> getRelationships() throws SQLException {
        List<Relationship> relatii = new ArrayList();
        String sql = "SELECT * FROM relationship ";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int id1 = rs.getInt("id1");
            int id2 = rs.getInt("id2");
            relatii.add(new Relationship(id, id1, id2));
        }

        return relatii;
    }

    @GetMapping({"/{id}"})
    public List<Relationship> getRelationships(@PathVariable("id") int id) throws SQLException {
        List<Relationship> relatii = new ArrayList();
        String sql = "SELECT * from relationship where id = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int id1 = rs.getInt("id1");
            int id2 = rs.getInt("id2");
            relatii.add(new Relationship(id, id1, id2));
        }

        return relatii;
    }
    public void verifyRelationship(int id1,int id2) throws SQLException {
        String sql1 = "Select * from relationship";
        PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
        ResultSet rs = pstmt1.executeQuery();
        while(rs.next())
        {
            if(rs.getInt("id1")==id1 && rs.getInt("id2")==id2)
            {
                throw new CustomNotFoundException("Relationship already exists");
            }
        }
    }
    @PostMapping
    public ResponseEntity<String> createRelationship(@RequestParam int id1, @RequestParam int id2) {
        try {
            verifyRelationship(id1,id2);
            int idCurrent = getIdMax();
            String sql1 = "INSERT INTO relationship values(?,?,?)";
            PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
            pstmt1.setInt(1, idCurrent);
            Person person=this.findById(id1);
            if(person==null)
                throw new CustomNotFoundException("Person not found with id:"+id1);
            pstmt1.setInt(2, id1);
            person=this.findById(id2);
            if(person==null)
                throw new CustomNotFoundException("Person not found with id:"+id2);
            pstmt1.setInt(3, id2);
            pstmt1.execute();
            addFriendship(id1);
            addFriendship(id2);
        } catch (SQLException var5) {
            var5.printStackTrace();
        }
        return new ResponseEntity("Relationship created successfully", HttpStatus.CREATED);
    }

    public void addFriendship(int id) throws SQLException {
        String sql1 = "Select * from person where id =?";
        PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
        pstmt1.setInt(1, id);
        ResultSet rs = pstmt1.executeQuery();
        String name = rs.getString("name");
        int numberOfFriends = rs.getInt("numberOfFriends");
        numberOfFriends++;
        String sql = "Insert into person values(id,name,numberOfFriends)";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        pstmt.execute();
    }

    @GetMapping("/most/{poz}")
    public ResponseEntity<String> mostConnectedPerson(@PathVariable int poz) throws SQLException {
        List<Integer> relatii = new ArrayList();
        String sql1 = "Select * from person";
        PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
        ResultSet rs = pstmt1.executeQuery();

        while (rs.next()) {
            int friends = rs.getInt("numberOfFriends");
            relatii.add(friends);
        }
        Collections.sort(relatii);
        int maxx = relatii.get(relatii.size() - poz);
        String sql = "Select * from person";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs1 = pstmt.executeQuery();
        String nameSave = " ";
        while (rs1.next()) {
            String name = rs1.getString("name");
            int number = rs1.getInt("numberOfFriends");
            if (number == maxx)
                nameSave = name;
        }

        return new ResponseEntity("Most Connected Person " + nameSave, HttpStatus.CREATED);

    }

    @GetMapping("/least/{poz}")
    public ResponseEntity<String> leastConnectedPerson(@PathVariable int poz) throws SQLException {
        List<Integer> relatii = new ArrayList();
        String sql1 = "Select * from person";
        PreparedStatement pstmt1 = this.connection.prepareStatement(sql1);
        ResultSet rs = pstmt1.executeQuery();
        while (rs.next()) {
            int friends = rs.getInt("numberOfFriends");
            relatii.add(friends);
        }
        Collections.sort(relatii);
        int maxx = relatii.get(poz);
        String sql = "Select * from person";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs1 = pstmt.executeQuery();
        String nameSave = " ";
        while (rs1.next()) {
            String name = rs1.getString("name");
            int number = rs1.getInt("numberOfFriends");
            if (number == maxx)
                nameSave = name;
        }

        return new ResponseEntity("Least Connected Person " + nameSave, HttpStatus.CREATED);

    }

    public int getIdMax() throws SQLException {
        String sql = "SELECT * from relationship";
        PreparedStatement pstmt = this.connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        int maxx = 0, idCurrent;
        while (rs.next()) {
            idCurrent = rs.getInt("id");
            if (idCurrent > maxx)
                maxx = idCurrent;
        }
        idCurrent = maxx + 1;
        return idCurrent;
    }
    public Person findById(int id) {
        Person persoana = new Person();

        try {
            String sql = "SELECT * from person ";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idCurrent = rs.getInt("id");
                if(idCurrent==id) {
                    persoana.setId(id);
                    persoana.setName(rs.getString("name"));
                    persoana.setFriends(rs.getInt("numberOfFriends"));
                    return persoana;
                }
            }
        } catch (SQLException var7) {
            var7.printStackTrace();
        }
        return null;
    }
}
