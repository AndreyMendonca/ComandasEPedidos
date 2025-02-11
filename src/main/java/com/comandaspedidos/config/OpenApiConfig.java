package com.comandaspedidos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Sistema De Comandas")
						.version("v1")
						.description("API de um sistema de comandas desenvolvida para ser consumida por uma aplicação React Native")
						.termsOfService("www.linkgenerico.com.br")
						.license(new License()
								.name("Apache 2.0")
								.url("www.linkgenerico.com.br"))
				);
	}
}
