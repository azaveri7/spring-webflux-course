package com.paathshala.productservice.repository;

import com.paathshala.productservice.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends ReactiveMongoRepository<Product, String> {
}
