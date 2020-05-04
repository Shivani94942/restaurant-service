package com.restaurant;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@ComponentScan

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class RestaurantServicesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServicesApplication.class, args);
	}
	
	@Bean 
	  public Docket swaggerConfiguration() {
	  
	  return new Docket(DocumentationType.SWAGGER_2)
			  .select()
			  .paths(PathSelectors.any())
			  .apis(RequestHandlerSelectors.basePackage("com.restaurant")) 
			  .build()
			  .apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		// TODO Auto-generated method stub
		
		return new ApiInfo("Restaurant api", 
				
					"Swagger api documenmtation for restaurant",					
					"2.0.0",					
					"Free to use",					
					new springfox.documentation.service.Contact("Restaurant", "http://restaurant.io", "abc@gmail.com"),					
					"API license", 
					"http://restaurant.io",					
					Collections.emptyList());
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	 
}
