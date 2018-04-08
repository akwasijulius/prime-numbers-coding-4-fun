/**
 * 
 */
package com.jog.apps.assignment.rbs.primes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig is for the configuration of Swagger documentation
 * 
 * @author Julius Oduro
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.jog.apps.assignment.rbs.primes.controller"))              
          .paths(PathSelectors.any())                          
          .build().apiInfo(apiMetaInfo());                                           
    }
	
	
	private ApiInfo apiMetaInfo() {
		return new ApiInfoBuilder()
                .title("RBS Assignment Prime Numbers REST API")
                .description("Spring Boot REST API for RBS Assignment Prime Numbers")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Julius Oduro", "https://www.linkedin.com/in/julius-oduro-8255629/", "julius.oduro@jogsoft.co.uk"))
                .build();
	}

}
