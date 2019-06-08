package eshop.repository;

import eshop.model.Product;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product addToDB(Product product) {
        return product;
    }

    @Override
    public Product updateDB(Product product) {
        return product;
    }

    //todo: @Robert to confirm if long required to check number of products before deletion? Why Long and not boolean?

    @Override
    public Long removeFromDB(Product product) {
        return null;
    }
}