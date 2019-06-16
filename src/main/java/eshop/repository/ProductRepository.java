package eshop.repository;

import eshop.model.Product;

import java.util.List;

public interface ProductRepository {

    Product addToDB(Product product);

    Product updateDB(Product product);

    Long removeFromDB(Product product);

    List<Product> retrieveFromDB();
}