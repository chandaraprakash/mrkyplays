package com.cp.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	static final String description = "Marketplace Microservice is a RESTful API that provides Apps to list the Projects and Hire Engineers\n" 
			+ "Below is the list of API's";
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("com.cp.microservices.web"))
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiInfo());
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Marketplace for Self Employed")
            .description(description)            
            .version("1.0.0")
            .build();
    }
}
