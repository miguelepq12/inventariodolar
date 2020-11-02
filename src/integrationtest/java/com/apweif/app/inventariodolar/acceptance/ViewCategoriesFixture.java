package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.entity.Category;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class ViewCategoriesFixture {

    List<Category> categories;

    @Before
    public void before() throws Exception {
        categories =new ArrayList<>();
        categories.add(new Category("Dulces","","#434342", LocalDateTime.now()));
        categories.add(new Category("Bebidas","","#434342", LocalDateTime.now()));
        categories.add(new Category("Bebidas alcoholicas","","#434342", LocalDateTime.now()));

    }

    public long getCategories(String name){
        return categories.stream().filter(category -> category.getName().contains(name)).count();
    }
}