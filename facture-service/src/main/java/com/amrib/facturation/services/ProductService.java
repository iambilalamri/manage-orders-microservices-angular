package com.amrib.facturation.services;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amrib.facturation.model.Product;

@FeignClient(name = "STOCK-SERVICE")
public interface ProductService {

	@GetMapping(value = "/products/{id}")
	public Product findProductById(@PathVariable(name = "id") Long id);

	@GetMapping(value = "/products")
	public  PagedModel<Product> findAllProducts();
}
