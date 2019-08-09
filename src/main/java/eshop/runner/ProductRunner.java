package eshop.runner;

import eshop.util.DBConnector;
import eshop.util.DBPropertiesReader;

import java.sql.SQLException;

public class ProductRunner {

    public static void main(String[] args) throws SQLException {

        if(DBConnector.setDBConnection(DBPropertiesReader.loadDBProperties())==null){
            System.out.println("Error");
        }
    }
}