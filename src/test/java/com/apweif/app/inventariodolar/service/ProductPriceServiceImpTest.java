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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class ProductPriceServiceImpTest {

    @InjectMocks
    ProductPriceService productPriceService=new ProductPricePriceServiceImp();
    @Mock
    ProductRepository productRepository;

    static Page<Product> productsPage;
    static List<Product> products;

    @BeforeAll
    static void beforeAll(){
        products=new ArrayList<>();
        products.add(new Product("1","Harina", "Comida", 2));
        products.add(new Product("2","Coca cola", "Bebidas", 4));
        products.add(new Product("3","Harina de trigo", "Otros", 3));
    }

    @Test
    void getProductsWithNameTest() {
        String name="Har";
        String category="";

        productsPage=new PageImpl<>(products.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList()));
        Mockito.when(productRepository.findByNameContaining(name, PageRequest.of(0,5)))
                .thenReturn(productsPage);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category).toList();

        Assertions.assertEquals(2,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    void getProductsWithCategTest() {
        String name="";
        String category="Bebidas";

        productsPage=new PageImpl<>(products.stream().filter(product -> product.getIdCategory().equals(category)).collect(Collectors.toList()));
        Mockito.when(productRepository.findByIdCategory(category, PageRequest.of(0,5)))
                .thenReturn(productsPage);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category).toList();

        Assertions.assertEquals(1,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    void getProductsWithCrossDtaTest() {
        String name="Har";
        String category="Bebidas";

        productsPage=new PageImpl<>(products.stream().filter(product -> product.getIdCategory().equals(category)&&product.getName().contains(name)).collect(Collectors.toList()));
        Mockito.when(productRepository.findByNameContainingAndIdCategoryIs(name,category, PageRequest.of(0,5)))
                .thenReturn(productsPage);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category).toList();

        Assertions.assertEquals(0,productPriceList.size());
    }

    @Test
    void getProductsTest() {
        String name="";
        String category="";

        productsPage=new PageImpl<>(products);
        Mockito.when(productRepository.findAll(PageRequest.of(0,5)))
                .thenReturn(productsPage);

        List<ProductPrice> productPriceList=productPriceService.getProductsPrice(name,category).toList();

        Assertions.assertEquals(3,productPriceList.size());
        Assertions.assertTrue(Objects.requireNonNull(productPriceList.stream().findFirst().stream().findFirst().orElse(null)).getPrice()>0);
    }

    @Test
    void addProductTest() {
        Product p=new Product("Caraotas", "Comida", 2);
        Product productNew=new Product("4",p.getName(),"cat",p.getPrice());

        Mockito.when(productRepository.save(p)).thenReturn(productNew);

        Assertions.assertNotNull(productPriceService.addProduct(p));
    }

}
