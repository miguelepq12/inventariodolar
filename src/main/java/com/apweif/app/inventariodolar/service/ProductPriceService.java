package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {
    List<ProductPrice> getProductsPrice(String name, String category);
    Product addProduct(Product p);
}
