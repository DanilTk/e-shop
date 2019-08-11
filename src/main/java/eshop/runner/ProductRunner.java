package eshop.runner;

import eshop.model.Product;
import eshop.model.enums.MeasureName;
import eshop.model.enums.ProductCategory;
import eshop.repository.ProductRepositoryImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

public class ProductRunner {

    public static void main(String[] args) throws SQLException {
        Product product = new Product("product_1", BigDecimal.valueOf(5.99), MeasureName.PIECE, ProductCategory.ELECTRONICS);

        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        productRepository.add(product);
    }
}