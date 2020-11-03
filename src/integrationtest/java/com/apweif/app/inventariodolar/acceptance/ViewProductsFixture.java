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
        products.add(new Product("1","Harina", "Otros", 2));
        products.add(new Product("1","Coca cola", "Bebidas", 4));
        products.add(new Product("1","Harina de trigo", "Bebidas alcoholicas", 3));

    }

    public long getProducts(String category,String name) {
        if (name.isEmpty() && category.isEmpty()) {
            return products.size();
        } else if (category.isEmpty()) {
            return products.stream().filter(p -> p.getName().contains(name)).count();
        } else if(name.isEmpty()){
            return products.stream().filter(p -> p.getIdCategory().equals(category)).count();
        }else{
            return products.stream().filter(p -> p.getIdCategory().equals(category)||p.getName().contains(name)).count();
        }
    }

}