package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.entity.Category;
import com.apweif.app.inventariodolar.entity.Product;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class ViewProductsFixture {

    List<Product> products;

    @Before
    public void before() throws Exception {
        products = new ArrayList<>();
        products.add(new Product("Harina", "", new Category("Otros", "", "#213231", LocalDateTime.now()),
                0, LocalDateTime.now()));
        products.add(new Product("Coca", "", new Category("Bebidas", "", "#213231", LocalDateTime.now()),
                0, LocalDateTime.now()));
        products.add(new Product("Harina de trigo", "", new Category("Bebidas alcoholicas", "", "#213231", LocalDateTime.now()),
                0, LocalDateTime.now()));

    }

    public long getProducts(String category,String name) {
        if (name.isEmpty() && category.isEmpty()) {
            return products.size();
        } else if (category.isEmpty()) {
            return products.stream().filter(p -> p.getName().contains(name)).count();
        } else if(name.isEmpty()){
            return products.stream().filter(p -> p.getCategory().getName().equals(category)).count();
        }else{
            return products.stream().filter(p -> p.getCategory().getName().equals(category)||p.getName().contains(name)).count();
        }
    }

}