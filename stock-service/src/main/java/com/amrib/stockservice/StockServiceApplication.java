package com.amrib.stockservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableEurekaClient
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository proRepository, RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Product.class);
			proRepository.save(new Product(null, "produit1", "description1", 125));
			proRepository.save(new Product(null, "produit2", "description2", 95));
			proRepository.save(new Product(null, "produit3", "description3", 16));
			proRepository.save(new Product(null, "produit4", "description4", 147));
			proRepository.findAll().forEach(System.out::println);

		};
	}

}
