package eshop.repository;

import eshop.model.Product;

import java.util.List;

public interface delete {

    Product add(Product product);

    Product update(Product product);

    Long delete(Product product);

    List<Product> getAll();
}