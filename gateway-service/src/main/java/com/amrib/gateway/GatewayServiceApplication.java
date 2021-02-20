package com.amrib.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator staticRoute(RouteLocatorBuilder locaBuilder) {
		// lb: load balancer
		return locaBuilder.routes().route("r1", r -> r.path("/publicCountries/**")
				.filters(f -> f.addRequestHeader("x-rapidapi-key", "9f687b9f32mshc52117066a4e098p1a028cjsn6c3369cb30c3")
						.addRequestHeader("x-rapidapi-host", "ajayakv-rest-countries-v1.p.rapidapi.com")
						.addRequestHeader("useQueryString", "true")
						.rewritePath("/publicCountries/(?<segment>.*)", "/${segment}")
				// .circuitBreaker(h ->
				// h.setName("countries").setFallbackUri("forward:/defaultCountries"))
				).uri("https://ajayakv-rest-countries-v1.p.rapidapi.com"))
				.route("r2", r -> r.path("/allCountries/**").uri("http://restcountries.eu/rest/v2/all"))
				.route("r3", r -> r.path("/salat/**").filters(f -> f
						.addRequestHeader("x-rapidapi-key", "9f687b9f32mshc52117066a4e098p1a028cjsn6c3369cb30c3")
						.addRequestHeader("x-rapidapi-host", "muslimsalat.p.rapidapi.com")
						.addRequestHeader("useQueryString", "true").rewritePath("/salat/(?<segment>.*)", "/${segment}"))
						.uri("https://muslimsalat.p.rapidapi.com"))
				.build();
	}

	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoute(ReactiveDiscoveryClient discoveryClient,
			DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
	}
}
