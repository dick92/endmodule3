package com.example.md3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/tcomplexmanagement";
    private static final String USER = "root";
    private static final String PASS = "codegym";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    public Database() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
