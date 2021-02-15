package com.amrib.ecom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amrib.ecom.model.Product;

@RepositoryRestResource(collectionResourceRel = "", path = "")
public interface ProductRepository extends MongoRepository<Product, String> {

}
