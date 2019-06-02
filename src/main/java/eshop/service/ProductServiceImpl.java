package eshop.service;

import eshop.model.Product;
import eshop.model.ProductCategory;
import eshop.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) throws ProductException {

        if (!ProductValidator.validateProduct(product)) {
            throw new ProductException("Product has been incorrectly initiated or absent");

        }

        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductException("Product has price 0 or negative");
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductException {

        if (ProductValidator.validateProduct(product)) {
            return productRepository.update(product);
        }
        throw new ProductException("Project fields are incomplete");
    }

    @Override
    public Long removeProduct(Product product) throws ProductServiceException {
        if (product == null) {
            throw new ProductServiceException("Cannot remove null product");
        }
        return productRepository.delete(product);
    }


    @Override
    public List<Product> filterByProductCategory(List<Product> products, ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory().equals(productCategory))
                .collect(toList());
    }

    @Override
    public List<Product> filterProducts(List<Product> products, Predicate<Product> predicate) {
        return products.stream()
                .filter(predicate)
                .collect(toList());
    }

    @Override
    public List<Product> findTopNumberOfProductsByCategory(List<Product> products, Integer numberOfElements, ProductCategory productCategory) {
        products.stream()
                .sorted((product1, product2) -> product1.getPrice().compareTo(product2.getPrice()))
                .filter(product -> product.getProductCategory().equals(productCategory))
                .limit(numberOfElements)
                .collect(toList());
        return null;
    }


    @Override
    public Map<ProductCategory, List<Product>> groupByProductCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.getProductCategory()));
    }
}
