package com.trainning.demo.swaggerdemo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoApplication.class, args);
	}
	
	@Bean
	public Docket configureSwager() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.trainning.demo.swaggerdemo"))
				.build().apiInfo(metaData());
	}
	
	 private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Spring Boot REST API",
	                "Spring Boot REST API for Customer",
	                "1.0",
	                "Terms of service",
	                new Contact("Niranjan Nallapu", "https://swaggerdoc.api", "niranjan@ymail.com"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0",new ArrayList<VendorExtension>());
	        return apiInfo;
	    }

}
