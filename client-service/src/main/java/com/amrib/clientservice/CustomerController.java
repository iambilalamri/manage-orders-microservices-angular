package com.amrib.clientservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping(value = "/hi/hello")
	public String hello() {
		return "Hello World";
	}

}
