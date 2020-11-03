package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductPriceService {
    Page<ProductPrice> getProductsPrice(String name, String category);
    Product addProduct(Product p);
}
