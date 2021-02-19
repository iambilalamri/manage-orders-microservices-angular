package com.amrib.facturation;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import com.amrib.facturation.model.Customer;
import com.amrib.facturation.model.Facture;
import com.amrib.facturation.model.Product;
import com.amrib.facturation.model.ProductItem;
import com.amrib.facturation.repository.FactureRepository;
import com.amrib.facturation.repository.ProductItemRepository;
import com.amrib.facturation.services.CustomerService;
import com.amrib.facturation.services.ProductService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FactureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactureServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(FactureRepository factureRepository, ProductItemRepository itemRepository,
			CustomerService customerService, ProductService productService, RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Facture.class);
			Customer c1 = customerService.findCustomerById(1L);
			System.out.println("****************************");
			System.out.println(c1);
			System.out.println("****************************");
			Facture facture1 = factureRepository.save(new Facture(null, new Date(), c1.getId(), null, null));

			PagedModel<Product> products = productService.findAllProducts();
			products.getContent().forEach(p -> {
				itemRepository.save(new ProductItem(null, p.getPrice(), 25, facture1, p.getProductId(), null));
			});
		};
	}
}
