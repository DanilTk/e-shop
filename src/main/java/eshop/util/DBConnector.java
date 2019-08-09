package eshop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    public static Connection setDBConnection(Properties properties) throws SQLException {

        String db_name = properties.getProperty("db_name");
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db_name, user, password);
    }
}