package eshop.runner;

import eshop.model.Basket;
import eshop.model.Client;
import eshop.model.Product;
import eshop.model.enums.MeasureName;
import eshop.model.enums.ProductCategory;
import eshop.service.BasketServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductRunner {


    public static void main(String[] args) {
        BasketServiceImpl basketService = new BasketServiceImpl(null);

        List<Basket> baskets = createListOfBaskets(3, 1);

        Map<Product, Set<Client>> groupedMap = basketService.groupClientShoppingByProduct(baskets);
    }

    private static List<Basket> createListOfBaskets(Integer numberOfBaskets, Integer productSetsPerBasket) {

        List<Basket> baskets = new ArrayList<>();

        for (int i = 0; i < numberOfBaskets; i++) {
            Client client = new Client("Client" + i, "Testing" + i, null);
            Basket basket = new Basket(client);
            BasketServiceImpl basketService = new BasketServiceImpl(basket);

            for (int j = 0; j < productSetsPerBasket; j++) {
                Product apple = new Product("Apple", BigDecimal.valueOf(1), MeasureName.KILOGRAM, ProductCategory.COFFEE);
                Product banana = new Product("Banana", BigDecimal.valueOf(10), MeasureName.GRAMM, ProductCategory.ELECTRONICS);
                Product orange = new Product("Orange", BigDecimal.valueOf(100), MeasureName.PIECE, ProductCategory.TEA);

                basketService.addProduct(apple);
                basketService.addProduct(banana);
                basketService.addProduct(orange);
            }
            baskets.add(basket);
        }
        return baskets;
    }
}