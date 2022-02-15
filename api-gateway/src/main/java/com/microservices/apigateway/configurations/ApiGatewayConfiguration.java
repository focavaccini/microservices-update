package com.microservices.apigateway.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f
								.addRequestHeader("Request", "Header")
								.addRequestParameter("Request", "Parameter"))
						.uri("http://httpbon.org:80"))
				.route(p -> p.path("/workers/**")
						.uri("lb://worker-service"))
				.route(p -> p.path("/payments/**")
						.uri("lb://payroll-service")).build();
	}
}
