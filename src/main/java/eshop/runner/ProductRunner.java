package eshop.runner;

import eshop.model.MeasureName;
import eshop.model.Product;
import eshop.model.ProductCategory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRunner {

    public static void main(String[] args) {


        Product p1 = new Product("n1", Double.valueOf(1), BigDecimal.valueOf(100), MeasureName.GRAMM, ProductCategory.ELECTRONICS);
        Product p2 = new Product("n2", Double.valueOf(1), BigDecimal.valueOf(100), MeasureName.KILOGRAM, ProductCategory.TEA);
        Product p3 = new Product("n3", Double.valueOf(1), BigDecimal.valueOf(100), MeasureName.PIECE, ProductCategory.COFFEE);


        List<Product> basketOne = new ArrayList<>();
        List<Product> basketTwo = new ArrayList<>();
        List<List<Product>> allProducts = new ArrayList<>();


        basketOne.add(p1);
        basketOne.add(p2);
        basketTwo.add(p3);
        allProducts.add(basketOne);
        allProducts.add(basketTwo);


    }


}
