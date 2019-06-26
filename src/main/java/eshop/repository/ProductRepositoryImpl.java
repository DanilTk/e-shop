package eshop.repository;

import eshop.model.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product addToDB(Product product) {
        return product;
    }

    @Override
    public Product updateDB(Product product) {
        return product;
    }

    @Override
    public Long removeFromDB(Product product) {
        return null;
    }

    public List<Product> retrieveFromDB() {
        return null;
    }
}