package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    @Getter
    private String username;
    @Getter
    private String pass;
}
