package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private static Connection connection;

    private Singleton() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/lab11", "root", "root");
            return connection;
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }

    }
}