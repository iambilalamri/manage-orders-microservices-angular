package com.amrib.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator staticRoute(RouteLocatorBuilder locaBuilder) {
		// lb: load balancer
		return locaBuilder.routes().route("r1", r -> r.path("/customers/**").uri("lb://CLIENT-SERVICE"))
				.route("r2", r -> r.path("/products/**").uri("lb://STOCK-SERVICE")).build();
	}

	// @Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoute(ReactiveDiscoveryClient discoveryClient,
			DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}
}
