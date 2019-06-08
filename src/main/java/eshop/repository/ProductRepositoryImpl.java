package eshop.repository;

import eshop.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Long delete(Product product) {
        return null;
    }
}