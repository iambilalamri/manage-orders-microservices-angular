package com.amrib.facturation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amrib.facturation.model.Facture;
import com.amrib.facturation.repository.FactureRepository;
import com.amrib.facturation.repository.ProductItemRepository;
import com.amrib.facturation.services.CustomerService;
import com.amrib.facturation.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FactureController {

	private final FactureRepository factureRepository;
	private final ProductItemRepository productItemRepository;
	private final CustomerService customerService;
	private final ProductService productService;

	@GetMapping(value = "/factureComplete/{id}")
	public Facture getFacture(@PathVariable(name = "id") Long id) {
		Facture facture = factureRepository.findById(id).get();
		facture.setCustomer(customerService.findCustomerById(facture.getCustomerId()));
		facture.getProductItems().forEach(p -> {
			p.setProduct(productService.findProductById(p.getProductId()));
		});
		return facture;
	}
}
