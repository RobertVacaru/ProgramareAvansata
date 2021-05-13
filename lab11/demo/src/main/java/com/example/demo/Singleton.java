package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Singleton {
    private static Connection con;

    public Singleton() {
    }
    public Connection getInstance() {
        if (con == null) {
            try {
                con =DriverManager.getConnection("jdbc:mariadb://localhost:3306/lab11", "root", "root");
            } catch (SQLException var5) {
                System.err.println("Cannot connect to DB: " + var5);
            } finally {
                if (con != null) {
                    System.out.println("Connexion created.\n");
                }

            }
        }
        return con;
    }

    public static Connection getCon() {
        return con;
    }
}
