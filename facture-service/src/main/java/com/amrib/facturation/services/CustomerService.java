package com.amrib.facturation.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amrib.facturation.model.Customer;

@FeignClient(name = "CLIENT-SERVICE")
public interface CustomerService {

	@GetMapping(value = "/customers/{id}")
	public Customer findCustomerById(@PathVariable(name = "id") Long id);
}
