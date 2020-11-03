package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Product {

    public Product(long id,String name,String category, double price) {
        this.name = name;
        this.id=id;
        this.description="";
        this.category=new Category(0,category,"","",LocalDateTime.now());
        this.price=price;
        this.createAt=LocalDateTime.now();
    }

    @Getter
    private long id;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private Category category;
    @Getter
    private double price;
    @Getter
    private LocalDateTime createAt;
}
