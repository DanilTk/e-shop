package eshop.runner;

import eshop.model.Product;
import eshop.model.enums.MeasureName;
import eshop.model.enums.ProductCategory;

import java.math.BigDecimal;
import java.sql.SQLException;

public class ProductRunner {

    public static void main(String[] args) throws SQLException {
//        Product product = new Product("product_1", BigDecimal.valueOf(5.99), MeasureName.PIECE, ProductCategory.ELECTRONICS);
//
//        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
//        productRepository.add(product);

        Product product1 = new Product("dan", BigDecimal.ONE,MeasureName.PIECE,ProductCategory.ELECTRONICS);
        product1.setId(5L);
        System.out.println(product1.getId());
    }
}