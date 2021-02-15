package com.amrib.ecom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amrib.ecom.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
