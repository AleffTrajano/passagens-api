package com.gama.passagens.config.docs;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket api() {
        /*
		return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
          */
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		 
		docket
		//.globalOperationParameters(params)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.gama.passagens.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build())
		.consumes(new HashSet<String>(Arrays.asList("application/json")))
		.produces(new HashSet<String>(Arrays.asList("application/json")));
		
		return docket;
    }
	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("passagens-api");
		apiInfoBuilder.description("API Rest para gerenciamento de Passagens");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Uso para estudos ...");
		apiInfoBuilder.license("Licença - Open Source");
		apiInfoBuilder.licenseUrl("http://www.gama.com.br");
		apiInfoBuilder.contact(this.contato());
		return apiInfoBuilder;
 
	}
	private Contact contato() {
 
		return new Contact(
				"Seu Nome / Meu Nome",
				"Se email / Meu E-mail",
				"Seu site");
	}
	 
}
