package com.apweif.app.inventariodolar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@Document(collection = "categories")
public class Category {
    public Category(String id,String name, String description, String color, LocalDateTime createAt) {
        this.name = name;
        this.id=id;
        this.description = description;
        this.color = color;
        this.createAt = createAt;
    }

    @Getter
    @Id
    private String id;
    @Getter
    private String name;
    @Getter
    private String description;
    @Getter
    private String color;
    @Getter
    @JsonIgnore
    private LocalDateTime createAt;
}
