package com.microservices.workerservice.configurations;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "Worker Service API", 
	version = "version 1.0", 
	description = "Documentation of Payroll Service API")
)
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Worker Service API")
						.version("version 1.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org"))
						);
	}
}