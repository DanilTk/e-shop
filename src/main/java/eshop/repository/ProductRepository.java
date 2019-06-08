package eshop.repository;

import eshop.model.Product;

public interface ProductRepository {

    Product addToDB(Product product);

    Product updateDB(Product product);

    Long removeFromDB(Product product);
}
