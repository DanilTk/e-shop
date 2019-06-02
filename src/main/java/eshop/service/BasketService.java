package eshop.service;

import eshop.model.Basket;
import eshop.model.Client;
import eshop.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BasketService {

    Basket addProduct(Product product);

    BigDecimal calculateClientBasket(Basket basket);

    Map<Product, List<Client>> groupClientShoppingByProduct(List<Basket> baskets);

}
