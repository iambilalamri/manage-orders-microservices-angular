package com.amrib.facturation;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amrib.facturation.model.Facture;
import com.amrib.facturation.model.ProductItem;
import com.amrib.facturation.repository.FactureRepository;
import com.amrib.facturation.repository.ProductItemRepository;

@SpringBootApplication
public class FactureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactureServiceApplication.class, args);
	}

	CommandLineRunner start(FactureRepository factureRepository, ProductItemRepository itemRepository) {
		return args -> {
			Facture facture1 = factureRepository.save(new Facture(null, new Date(), 1L, null));
			itemRepository.save(new ProductItem(null, 800.0, 25, facture1, 1L));
			itemRepository.save(new ProductItem(null, 700.0, 25, facture1, 2L));
			itemRepository.save(new ProductItem(null, 600.0, 25, facture1, 3L));
		};
	}
}
