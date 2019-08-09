package eshop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertiesReader {

    Properties properties = new Properties();

    public static Properties loadDBProperties() {

        Properties prop = new Properties();

        try (InputStream input = DBPropertiesReader.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new NullPointerException();
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}