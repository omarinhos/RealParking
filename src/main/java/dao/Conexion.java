package dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            try {
                Properties prop = getProperties();

                String url = prop.getProperty("db.url");
                String user = prop.getProperty("db.user");
                String pass = prop.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, pass);

            } catch (IOException e) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return connection;
    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        File configFile = new File(propFileName);

        if (configFile.exists()) {
            try (InputStream inputStream = new FileInputStream(configFile)) {
                prop.load(inputStream);
            }
        } else {
            throw new FileNotFoundException("Archivo de configuración '" + propFileName + "' no encontrado.");
        }
        return prop;
    }
}
