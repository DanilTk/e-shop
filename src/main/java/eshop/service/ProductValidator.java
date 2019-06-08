package eshop.service;

import eshop.model.Product;
import eshop.service.exceptions.ProductException;

public class ProductValidator {

    public static boolean validateProduct(Product product) throws ProductException {

        if (product == null) {
            return false;
        }

        if (!validateProductName(product)
                || !validateProductQuantity(product)
                || !validateProductPrice(product)
                || !validateProductMeasureName(product)
                || !validateProductCategory(product)) {
            return false;
        }
        return true;
    }


    private static boolean validateProductName(Product product) {
        if (product.getName() == null) {
            return false;
        }
        return true;
    }

    private static boolean validateProductMeasureName(Product product) {

        if (product.getMeasureName() == null) {
            return false;
        }
        return true;
    }

    private static boolean validateProductPrice(Product product) {

        if (product.getPrice() == null) {
            return false;
        }
        return true;
    }

    private static boolean validateProductCategory(Product product) {

        if (product.getProductCategory() == null) {
            return false;
        }
        return true;
    }

    private static boolean validateProductQuantity(Product product) {

        if (product.getQuantity() == null) {
            return false;
        }
        return true;
    }
}