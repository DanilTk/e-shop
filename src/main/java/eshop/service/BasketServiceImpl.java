package eshop.service;

import eshop.model.Basket;
import eshop.model.Client;
import eshop.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class BasketServiceImpl implements BasketService {

    private Basket basket;

    public BasketServiceImpl(Basket basket) {
        this.basket = basket;
    }

    @Override
    public Basket addProduct(Product product) {
        basket.getProducts().add(product);
        return basket;
    }

    @Override
    public BigDecimal calculateClientBasket(Basket basket) {
        BigDecimal basketPrice = BigDecimal.ZERO;

        List<Product> clientProducts = basket.getProducts();

        BigDecimal total = clientProducts.stream()
                .map(Product::getPrice)
                .reduce(basketPrice, BigDecimal::add);

        return total;
    }

    @Override
    public Map<Product, List<Client>> groupClientShoppingByProduct(List<Basket> baskets) {

        baskets.stream()
                .map(Basket::getProducts)
                .flatMap(List::stream)
                .distinct()
                .collect(toList());

        return null;
    }


}
