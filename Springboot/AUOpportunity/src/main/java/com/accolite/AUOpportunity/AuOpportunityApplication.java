package com.accolite.AUOpportunity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class AuOpportunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuOpportunityApplication.class, args);
	}
	
	@Value("app.allowed-origins")
    private String[] allowedOrigins;
    
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(allowedOrigins);
			}
		};
	}

}
