package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Product {
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
