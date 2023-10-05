package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/real_parking";
    private static final String USER = "omar";
    private static final String PASS = "c0ntrAseña*";
    
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }
        return connection;
    }
    
}