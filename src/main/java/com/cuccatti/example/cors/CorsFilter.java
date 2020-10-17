package com.cuccatti.example.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsFilter {

	private static final String[] CORS_ALLOWED_METHODS = { "HEAD", "OPTIONS", "GET", "PUT", "POST", "DELETE" };

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods(CORS_ALLOWED_METHODS);
			};
		};
	}
}
