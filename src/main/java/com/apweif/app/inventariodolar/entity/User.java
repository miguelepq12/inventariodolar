package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class User {
    @Getter
    private String username;
    @Getter
    private String pass;
}
