package com.amrib.clientservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration configuration) {
		return args -> {
			configuration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "ENSISA", "ensisa@uha.fr"));
			customerRepository.save(new Customer(null, "IBN", "ibn@euha.fr"));
			customerRepository.save(new Customer(null, "CGI", "cgi@guha.fr"));
			customerRepository.save(new Customer(null, "ENS", "ens@uha.fr"));
			customerRepository.findAll().forEach(System.out::println);

		};
	}

}
