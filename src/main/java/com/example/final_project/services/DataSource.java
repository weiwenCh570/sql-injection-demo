package com.example.final_project.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static Connection connection = null;

    private DataSource() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                // Parse and initialize fields
                String[] info = (new Utility()).loadDBInfo("database.properties");
                String driverString = "com.mysql.cj.jdbc.Driver";
                Class.forName(driverString);
                String serverUrl = "jdbc:" + info[0] + "://" + info[2] + ":" + info[4] + "/" + info[1];
                System.out.println(serverUrl);
                connection = DriverManager.getConnection(serverUrl, info[5], info[3]);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver class not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return connection;
    }
}
