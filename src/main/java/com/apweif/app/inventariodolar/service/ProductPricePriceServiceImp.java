package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import com.apweif.app.inventariodolar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPricePriceServiceImp implements ProductPriceService {
    @Autowired
    ProductRepository repository;

    @Override
    public List<ProductPrice> getProductsPrice(String name, String category) {
        return null;
    }

    @Override
    public Product addProduct(Product p) {
        return null;
    }
}
