package com.codegnan.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class ConnectionHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/adjava";
    private static final String USER = "root";
    private static final String PASS = "root";
 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}


 
 
 
 
 
 