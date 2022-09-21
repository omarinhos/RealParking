package servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String url = "jdbc:mysql://localhost:3306/real_parking";
    private static final String user = "root";
    private static final String pass = "root";

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    
}