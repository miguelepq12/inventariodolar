package com.apweif.app.inventariodolar.service;

import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import com.apweif.app.inventariodolar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductPricePriceServiceImp implements ProductPriceService {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<ProductPrice> getProductsPrice(String name, String category) {
        Pageable pageable=PageRequest.of(0, 5);
        Page<Product> productsWithoutPrice;

        if (name.isEmpty() && category.isEmpty()) {
           productsWithoutPrice= repository.findAll(pageable);
        } else if (category.isEmpty()) {
            productsWithoutPrice= repository.findByNameContaining(name,pageable);
        } else if(name.isEmpty()){
            productsWithoutPrice= repository.findByIdCategory(category,pageable);
        }else{
            productsWithoutPrice= repository.findByNameContainingAndIdCategoryIs(name,category,pageable);
        }

        return  productsWithoutPrice.map(this::getPriceProduct);
    }

    @Override
    public Product addProduct(Product p) {
        return repository.save(p);
    }

    private ProductPrice getPriceProduct(final Product p) {
        return new ProductPrice(p,550000);
    }
}
