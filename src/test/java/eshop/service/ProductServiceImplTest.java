package eshop.service;

import eshop.model.Product;
import eshop.model.enums.MeasureName;
import eshop.model.enums.ProductCategory;
import eshop.repository.ProductRepositoryImpl;
import eshop.service.exceptions.ProductException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepositoryImpl productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private static Product createProduct() {

        return new Product("Product",
                BigDecimal.valueOf(100),
                2d,
                MeasureName.PIECE,
                ProductCategory.ELECTRONICS);
    }

    private static List<Product> createProductList(Integer numberOfProducts, BigDecimal price, Double quantity, MeasureName measureName, ProductCategory productCategory) {

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product("Product_" + i,
                    price,
                    quantity,
                    measureName,
                    productCategory);

            products.add(product);
        }
        return products;
    }

    private static Predicate<Product> productPricePredicate(BigDecimal price) {
        return product -> product.getPrice().compareTo(price) > 0;
    }

    private static Predicate<Product> productCategoryPredicate(ProductCategory productCategory) {
        return product -> product.getProductCategory().equals(productCategory);
    }

    @Test
    public void addProduct_whenProductIsCorrect_shouldReturnAddedProduct() throws ProductException {

        //given
        Product product = createProduct();
        Mockito.when(productRepository.addToDB(any(Product.class))).thenReturn(product);

        //when
        Product addedProduct = productService.addProduct(product);

        //then
        assertThat(product, equalTo(addedProduct));
    }

    @Test
    public void updateProduct_whenProductIsCorrect_shouldReturnUpdatedProduct() throws ProductException {

        //given
        Product product = createProduct();
        Mockito.when(productRepository.updateDB(any(Product.class))).thenReturn(product);

        //when
        Product updatedProduct = productService.updateProduct(product);

        //then
        assertThat(product, equalTo(updatedProduct));
    }

    @Test
    public void removeProduct_whenProductIsNotNull_shouldReturnId() throws ProductException {

        //given
        Product product = createProduct();
        Mockito.when(productRepository.removeFromDB(any(Product.class))).thenReturn(anyLong());

        //when
        Long removedProduct = productService.removeProduct(product);

        //then
        Assert.assertThat(removedProduct, instanceOf(Long.class));
    }

    @Test
    public void findTopNumberOfProductsByCategory_shouldReturnFilteredNumberOfProducts() {

        //given
        List<Product> products = createProductList(5, BigDecimal.valueOf(100), 10d, MeasureName.PIECE, ProductCategory.ELECTRONICS);
        products.addAll(createProductList(8, BigDecimal.valueOf(300), 50d, MeasureName.GRAMM, ProductCategory.TEA));
        Integer topNumberOfProducts = 7;
        ProductCategory productCategory = ProductCategory.TEA;

        //when
        List<Product> filteredProducts = productService.findTopNumberOfProductsByCategory(products, topNumberOfProducts, productCategory);

        //then
        assertThat(filteredProducts, hasSize(7));
        assertThat(filteredProducts, everyItem(hasProperty("productCategory", equalTo(ProductCategory.TEA))));
    }

    @Test
    public void filterProducts_withPriceHigherThanPredicate_shouldReturnListOfProductsWithPriceMatchingThreshold() {

        //given
        List<Product> products = createProductList(4, BigDecimal.valueOf(100), 10d, MeasureName.PIECE, ProductCategory.ELECTRONICS);
        products.addAll(createProductList(8, BigDecimal.valueOf(30), 50d, MeasureName.GRAMM, ProductCategory.TEA));
        Predicate<Product> pricePredicate = productPricePredicate(BigDecimal.valueOf(90));

        //when
        List<Product> filteredProducts = productService.filterProducts(products, pricePredicate);

        //then
        assertThat(filteredProducts, hasSize(4));
        assertThat(filteredProducts, everyItem(hasProperty("price", greaterThan(BigDecimal.valueOf(90)))));
    }

    @Test
    public void filterProducts_withProductCategoryPredicate() {

        //given
        List<Product> products = createProductList(4, BigDecimal.valueOf(100), 10d, MeasureName.PIECE, ProductCategory.ELECTRONICS);
        products.addAll(createProductList(8, BigDecimal.valueOf(30), 50d, MeasureName.GRAMM, ProductCategory.TEA));
        Predicate<Product> categoryPredicate = productCategoryPredicate(ProductCategory.ELECTRONICS);

        //when
        List<Product> filteredProducts = productService.filterProducts(products, categoryPredicate);

        //then
        assertThat(filteredProducts, hasSize(4));
        assertThat(filteredProducts, everyItem(hasProperty("productCategory", equalTo(ProductCategory.ELECTRONICS))));

    }

    @Test
    //TODO: Test each map's list size and content
    //TODO: Robert to advise on assertThat implementation below - not working correctly
    public void groupByProductCategory_shouldReturnMapOfProductCategoryAndListOfProducts() {

        //given
        List<Product> products = createProductList(4, BigDecimal.valueOf(100), 10d, MeasureName.PIECE, ProductCategory.ELECTRONICS);
        products.addAll(createProductList(8, BigDecimal.valueOf(30), 50d, MeasureName.GRAMM, ProductCategory.TEA));

        //when
        Map<ProductCategory, List<Product>> groupedProducts = productService.groupByProductCategory(products);

        //then
        //assertThat(groupedProducts, hasSize(2));
        Assert.assertEquals(2, groupedProducts.size());
    }
}