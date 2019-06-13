//package eshop.service;
//
//import eshop.model.Product;
//import eshop.model.enums.MeasureName;
//import eshop.model.enums.ProductCategory;
//import eshop.repository.ProductRepositoryImpl;
//import eshop.service.exceptions.ProductException;
//import eshop.service.exceptions.ProductServiceException;
//import org.hamcrest.CoreMatchers;
//import org.hamcrest.MatcherAssert;
//import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductServiceTestBackup {
//
//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//    @Mock
//    private ProductRepositoryImpl productRepository;
//
//
//    private static Predicate<Product> priceIsHigherThan(BigDecimal price) {
//        return product -> product.getPrice().compareTo(price) > 0;
//    }
//
//    @Before
//    public void setup() {
////        this.productService = new ProductServiceImpl();
//    }
//
//    @Test
//    public void filterByProductCategory_whenCorrectProductCategory_shouldReturnFilteredProducts() {
//        // Name of test syntax: Method Name + condition + expected result (given when then)
//
//        //given
//
//        List<Product> products = createProducts(2, ProductCategory.COFFEE);
//        products.addAll(createProducts(3, ProductCategory.TEA));
//
//        //when
//        List<Product> filteredProducts = productService.filterByProductCategory(products, ProductCategory.TEA);
//
//        //then
//        assertNotNull(filteredProducts);
//        MatcherAssert.assertThat(filteredProducts, Matchers.hasSize(3));
//        MatcherAssert.assertThat(
//                filteredProducts.stream()
//                        .map(Product::getProductCategory)
//                        .collect(Collectors.toList()),
//                CoreMatchers.hasItems(ProductCategory.TEA));
//    }
//
//    @Test
//    public void filterProducts_whenUsedPredicatePriceIsHigherThan_shouldReturnProductsWithPriceHigher() {
//
//        //given
//
//        List<Product> products = createProducts(2, ProductCategory.COFFEE);
//        products.addAll(createProducts(3, ProductCategory.ELECTRONICS));
//
//        //when
//        List<Product> filteredProducts = productService.filterProducts(products, priceIsHigherThan(BigDecimal.valueOf(90)));
//
//        //then
//        assertNotNull(filteredProducts);
//        MatcherAssert.assertThat(filteredProducts, Matchers.hasSize(5));
//
//
//    }
//
//    @Test
//    public void filterProducts_whenUsedPredicatePriceIsHigherThanGiven_shouldReturnProductsWithPriceHigherThanGiven() {
//        //given
//        List<Product> products = createProducts(4, ProductCategory.COFFEE);
//        products.addAll(createProducts(4, ProductCategory.TEA));
//        products.addAll(createProducts(4, ProductCategory.ELECTRONICS));
//
//        //when
//        List<Product> filteredProducts = productService.filterProducts(products, priceIsHigherThan(BigDecimal.valueOf(50)));
//
//        //then
//        assertNotNull(filteredProducts);
//        assertThat(filteredProducts, Matchers.hasSize(12));
//        assertThat(filteredProducts.stream()
//                        .map(product -> product.getPrice())
//                        .collect(Collectors.toList()),
//                Matchers.hasItems(BigDecimal.valueOf(100)));
//    }
//
//
//    private List<Product> createProducts(Integer numberOfProducts, ProductCategory productCategory) {
//        List<Product> products = new ArrayList<>();
//        for (int i = 0; i < numberOfProducts; i++) {
//            Product newProduct = new Product("product" + i, BigDecimal.valueOf(5), 2d, MeasureName.PIECE, ProductCategory.ELECTRONICS);
//            products.add(newProduct);
//        }
//
//        return products;
//    }
//
//
//}