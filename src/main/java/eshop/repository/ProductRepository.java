package eshop.repository;

import eshop.model.Product;
import eshop.util.DBConnector;
import eshop.util.DBPropertiesReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ProductRepository implements Repository<Product> {

    private Connection connection;

    private static String buildAddQuery(String name, Double price, String measureName, String productCategory) {

        return new StringBuilder()
                .append("INSERT INTO product (name, price, measure_name, product_category) VALUES ('")
                .append(name)
                .append("', '")
                .append(price)
                .append("', '")
                .append(measureName)
                .append("', '")
                .append(productCategory)
                .append("')")
                .toString();
    }

    @Override
    public Product add(Product product) {

        String name = product.getName();
        Double price = product.getPrice().doubleValue();
        String measureName = product.getMeasureName().toString();
        String productCategory = product.getProductCategory().toString();

        try {
            Statement statement = connection.createStatement();
            String addProductSQL = buildAddQuery(name, price, measureName, productCategory);

//                String addProductSQL = "INSERT INTO product(name) VALUES('" + name + "')";
            statement.executeUpdate(addProductSQL);
        } catch (SQLException e) {
            //TODO add logger
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }

    @Override
    public Product getAll(Product product) {
        return null;
    }

    private void init() {
        Properties properties = DBPropertiesReader.loadDBProperties();
        try {
            connection = DBConnector.createDbConnection(properties);
        } catch (SQLException e) {
            // TODO manage exception
        }
    }
}
