package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import com.apweif.app.inventariodolar.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@ExtendWith(MockitoExtension.class)
public class ProductPriceServiceImpTest {

    @InjectMocks
    ProductPriceService productPriceService;
    @Mock
    ProductRepository productRepository;

    static List<Product> products;

    @BeforeAll
    static void beforeAll(){
        products= new ArrayList<>();
        products.add(new Product(1,"Harina", "Comida", 2));
        products.add(new Product(1,"Coca cola", "Bebidas", 4));
        products.add(new Product(1,"Harina de trigo", "Otros", 3));

    }

    @Test
    public void getProductsWithoutCategoryTest() {
        String name="Har";
        String category="";

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category);

        Mockito.verify(productRepository).findAll();

        Assertions.assertEquals(2,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    public void getProductsWithoutName() {
        String name="";
        String category="Bebidas";

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category);

        Mockito.verify(productRepository).findAll();

        Assertions.assertEquals(1,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    public void getProductsWithCrossData() {
        String name="Har";
        String category="Bebidas";

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category);

        Mockito.verify(productRepository).findAll();

        Assertions.assertEquals(0,productPriceList.size());
    }

    @Test
    public void getProducts() {
        String name="";
        String category="";

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category);

        Mockito.verify(productRepository).findAll();

        Assertions.assertEquals(3,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    public void addProductTest(Product p) {
        Product productNew=new Product(4,p.getName(),p.getCategory().getName(),p.getPrice());

        Mockito.when(productRepository.save(p)).thenReturn(productNew);

        Assertions.assertNotNull(productPriceService.addProduct(p));
    }

}
