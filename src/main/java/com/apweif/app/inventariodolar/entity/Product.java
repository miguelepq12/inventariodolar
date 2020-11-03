package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    public Product(String id,String name,String category, double price) {
        this.name = name;
        this.description="";
        this.idCategory=category;
        this.price=price;
        this.createAt=LocalDateTime.now();
    }

    public Product(String name,String category, double price) {
        this.name = name;
        this.description="";
        this.idCategory=category;
        this.price=price;
        this.createAt=LocalDateTime.now();
    }

    @Getter
    @Id
    private String id;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private String idCategory;
    @Getter
    private double price;
    @Getter
    private LocalDateTime createAt;
}
