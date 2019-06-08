package eshop.repository;

import eshop.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product save(Product product) {
        return product;
    }

    @Override
    public Product update(Product product) {
        return product;
    }

    //todo: @Robert to confirm if long required to check number of products before deletion? Why Long and not boolean?

    @Override
    public Long delete(Product product) {
        return null;
    }
}