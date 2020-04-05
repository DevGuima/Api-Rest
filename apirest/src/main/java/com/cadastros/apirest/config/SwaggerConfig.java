package com.cadastros.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket pessoaApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cadastros.apirest"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo()); 
	}
	
	
	
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("Pessoas API REST", "API REST de cadastro de pessoas", "1.0", "Terms of Service", 
				new Contact("Glecio Heybel", "https://github.com/DevGuima", "Glecioheybel@hotmail.com"), 
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());
		return apiInfo;
	}
}

