package com.apweif.app.inventariodolar.repository;

import com.apweif.app.inventariodolar.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Page<Product> findByNameContaining(String name, Pageable pageable);
    Page<Product> findByIdCategory(String categoryName, Pageable pageable);
    Page<Product> findByNameContainingAndIdCategoryIs(String name, String categoryName, Pageable pageable);
}
