package com.amrib.gateway;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

	@GetMapping("/defaultCountries")
	public Map<String, String> countries() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("message", "default countries");
		data.put("countries", "France, Canada, Italie, ...");
		return data;
	}

	@GetMapping("/defaultSalats")
	public Map<String, String> salats() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("Fajr", "5:00");
		data.put("evening", "19:30");
		data.put("message", "Horaire de Salat en Senegal");
		return data;
	}
}
