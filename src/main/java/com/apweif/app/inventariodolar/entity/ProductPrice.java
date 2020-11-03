package com.apweif.app.inventariodolar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ProductPrice {
    public ProductPrice(Product product,double precioDolar) {
        this.product = product;
        this.precioDolar=precioDolar;
    }

    @Getter
    Product product;
    double precioDolar;

    public double getPrice() {
        return product.getPrice()*precioDolar;
    }
}
