package com.amrib.ecom.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amrib.ecom.model.Product;
import com.amrib.ecom.repository.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	public void init() {
		productRepository.deleteAll();

		Product product = new Product();
		product.setCode("1DIN152");
		product.setDescription("Description1");
		product.setImgURL("imageURL1");
		product.setName("name1");
		product.setPrice(Double.valueOf(152));
		product.setTitle("Title1");
		productRepository.save(product);
		
		product = new Product();
		product.setCode("2DIN145");
		product.setDescription("Description2");
		product.setImgURL("imageURL2");
		product.setName("name2");
		product.setPrice(Double.valueOf(145));
		product.setTitle("Title2");
		productRepository.save(product);
	}

}
