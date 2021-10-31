package com.ecommerce.item.config;

import org.springframework.context.annotation.Bean;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	@Bean
	public Docket swaggerDocket()
	{
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.paths(
	PathSelectors.ant("/getItem/*")
	.or( PathSelectors.ant("/getItems/*") )
	.or( PathSelectors.ant("/getItems/**") )

	.or( PathSelectors.ant("/getItemsKeyword/*") )
	.or( PathSelectors.ant("/getItemType/**") )


	)
	.apis(RequestHandlerSelectors.basePackage("com.ecommerce.item"))
	.build()
	.apiInfo(apiDetails());
	}
	
	
	
	public ApiInfo apiDetails()
	{
	return new ApiInfo("Item-Service", "This service retrieves item details"
	+ "\n . category"
	+ "\n . Jeans ,Shirts ,Formals,Kurthas",
	"1.0", "Free Api",
	new Contact("Fasscio","vamsi.com","vk98@gmail.com"), "My Licence",
	"http://localhost:8082", Collections.emptyList());
	}
}
