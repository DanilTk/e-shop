package eshop.repository;

import eshop.model.Product;

public interface ProductRepository {

    Product save(Product product);
    Product update(Product product);
    Long delete(Product product);
}
