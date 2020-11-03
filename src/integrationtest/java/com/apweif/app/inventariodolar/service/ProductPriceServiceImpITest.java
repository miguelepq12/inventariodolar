package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductPriceServiceImpITest {

    @Autowired
    ProductRepository repository;

    @Before
    public void init() {
        repository.deleteAll();

        repository.save(new Product("Harina", "Comida", 2));
        repository.save(new Product("Coca cola", "Bebidas", 4));
        repository.save(new Product("Harina de trigo", "Otros", 3));
    }


    @Test
    public void getProductsWithoutCategoryTest() {
        String name="Har";

        Page<Product> products=repository.findByNameContaining(name,PageRequest.of(0,5));
        Assertions.assertTrue(products.stream().count()>0);
    }

    @Test
    public void getProductsWithoutName() {
        String category="Bebidas";

        Page<Product> products=repository.findByIdCategory(category,PageRequest.of(0,5));
        Assertions.assertTrue(products.stream().count()>0);
    }

    @Test
    public void getProductsWithCrossData() {
        String name="Har";
        String category="Carrito";

        Page<Product> products=repository.findByNameContainingAndIdCategoryIs(name,category,PageRequest.of(0,5));
        Assertions.assertEquals(0, products.stream().count());
    }

    @Test
    public void getProducts() {
        Page<Product> products=repository.findAll(PageRequest.of(0,5));
        Assertions.assertTrue(products.getSize()>0);
    }

}
