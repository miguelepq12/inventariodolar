package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Category {
    @Getter
    private long id;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private String color;
    @Getter
    private LocalDateTime createAt;
}
