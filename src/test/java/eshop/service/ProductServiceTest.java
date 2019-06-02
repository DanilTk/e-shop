package eshop.service;

import eshop.model.MeasureName;
import eshop.model.Product;
import eshop.model.ProductCategory;
import eshop.repository.ProductRepositoryImpl;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepositoryImpl productRepository;


    private static Predicate<Product> priceIsHigherThan(BigDecimal price) {
        return product -> product.getPrice().compareTo(price) > 0;
    }

    @Before
    public void setup() {
//        this.productService = new ProductServiceImpl();
    }

    @Test
    public void filterByProductCategory_whenCorrectProductCategory_shouldReturnFilteredProducts() {
        // Name of test syntax: Method Name + condition + expected result (given when then)

        //given

        List<Product> products = createProducts(2, ProductCategory.COFFEE);
        products.addAll(createProducts(3, ProductCategory.TEA));

        //when
        List<Product> filteredProducts = productService.filterByProductCategory(products, ProductCategory.TEA);

        //then
        assertNotNull(filteredProducts);
        MatcherAssert.assertThat(filteredProducts, Matchers.hasSize(3));
        MatcherAssert.assertThat(
                filteredProducts.stream()
                        .map(Product::getProductCategory)
                        .collect(Collectors.toList()),
                CoreMatchers.hasItems(ProductCategory.TEA));
    }

    @Test
    public void filterProducts_whenUsedPredicatePriceIsHigherThan_shouldReturnProductsWithPriceHigher() {

        //given

        List<Product> products = createProducts(2, ProductCategory.COFFEE);
        products.addAll(createProducts(3, ProductCategory.ELECTRONICS));

        //when
        List<Product> filteredProducts = productService.filterProducts(products, priceIsHigherThan(BigDecimal.valueOf(90)));

        //then
        assertNotNull(filteredProducts);
        MatcherAssert.assertThat(filteredProducts, Matchers.hasSize(5));


    }

    @Test
    public void filterProducts_whenUsedPredicatePriceIsHigherThanGiven_shouldReturnProductsWithPriceHigherThanGiven() {
        //given
        List<Product> products = createProducts(4, ProductCategory.COFFEE);
        products.addAll(createProducts(4, ProductCategory.TEA));
        products.addAll(createProducts(4, ProductCategory.ELECTRONICS));

        //when
        List<Product> filteredProducts = productService.filterProducts(products, priceIsHigherThan(BigDecimal.valueOf(50)));

        //then
        assertNotNull(filteredProducts);
        assertThat(filteredProducts, Matchers.hasSize(12));
        assertThat(filteredProducts.stream()
                        .map(product -> product.getPrice())
                        .collect(Collectors.toList()),
                Matchers.hasItems(BigDecimal.valueOf(100)));
    }
//TODO: Finish Test
//    @Test(expected = ProductServiceException.class)
//    public void addProduct_shouldThrowException_whenProductIsNull() throws ProductServiceException, ProductException {
//        //given
//        //when
//        productService.addProduct(null);
//        //then
//
//    }

//TODO: Ammend Test
//    @Test
//    public void addProduct_shouldThrowNegativePriceException_whenPriceIsBelowOrZero() throws ProductServiceException, ProductException {
//        exceptionRule.expect(ProductServiceException.class);
//        exceptionRule.expectMessage("Product has price 0 or negative");
//
//        Product product = new Product("Chips",
//                5.5,
//                BigDecimal.valueOf(0),
//                MeasureName.KILOGRAM,
//                ProductCategory.TEA);
//
//        productService.addProduct(product);
//    }

    @Test
    public void addProduct_shouldAddProduct_whenProductIsNotNullAndValid() throws ProductServiceException, ProductException {
        //given
        Product product = new Product("Chips", 5.0, BigDecimal.valueOf(44), MeasureName.KILOGRAM, ProductCategory.TEA);

        //when
        productService.addProduct(product);

        //then
        Mockito.verify(productRepository, times(1)).save(product);
    }

    private List<Product> createProducts(Integer numberOfProducts, ProductCategory productCategory) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < numberOfProducts; i++) {
            Product newProduct = new Product(
                    "Name" + i,
                    10d,
                    BigDecimal.valueOf(100),
                    MeasureName.PIECE,
                    productCategory);
            products.add(newProduct);
        }

        return products;
    }


    @Test
    public void deleteProduct_shouldReturnProductId_whenProductIsNotNull() throws ProductServiceException {

        //given
        Product product = new Product("Chips", 5.0, BigDecimal.valueOf(44), MeasureName.KILOGRAM, ProductCategory.TEA);
        Mockito.when(productRepository.delete(any(Product.class))).thenReturn(anyLong());

        //when
        Long idOfRemovedProduct = productService.removeProduct(product);

        //then
        assertNotNull(idOfRemovedProduct);
        Mockito.verify(productRepository, times(1)).delete(any(Product.class));

    }

    @Test(expected = ProductServiceException.class)
    public void deleteProduct_shouldThrowException_whenProductIsNull() throws ProductServiceException {

        //when
        productService.removeProduct(null);
        exceptionRule.expectMessage("Cannot remove null product");
    }

    @Test
    public void updateProduct_whenProductIsCorrect_shouldReturnUpdatedProduct() throws ProductException {
        //given
        Product product = new Product("Chips",
                5.0,
                BigDecimal.valueOf(44),
                MeasureName.KILOGRAM,
                ProductCategory.TEA);

        Mockito.when(productRepository.update(any(Product.class))).thenReturn(product);

        //when
        Product result = productService.updateProduct(product);

        //then
        assertNotNull(result);
    }
}