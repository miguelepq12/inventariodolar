package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CategoryServiceImpTest {

    @Test
    void addCategoryTest(){
        Category category=new Category("1","Otros","desc","#32323", LocalDateTime.now());
        Assertions.assertNotNull(category);
    }
}
