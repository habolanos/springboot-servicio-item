package com.formaciondbi.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	@Bean("clienteRestTemplate")
	public RestTemplate clienteRestTemplate() {
	return new RestTemplate();	
	}
}