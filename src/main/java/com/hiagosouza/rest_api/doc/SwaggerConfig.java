package com.hiagosouza.rest_api.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SwaggerConfig {
  private Contact contact() {
    return new Contact(
            "Hiago Souza",
            "https://github.com/ohiagosouza",
            "ohiagossouza@gmail.com"
    );
  }

  private ApiInfoBuilder apiInfos() {
    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

    apiInfoBuilder.title("Web RESTful API");
    apiInfoBuilder.description("RESTful API to create, read, update and delete using Springboot");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.termsOfServiceUrl("Terms of Use: Open Source");
    apiInfoBuilder.license("License - @ohiagosouza");
    apiInfoBuilder.licenseUrl("https://hiagosouza.com");
    apiInfoBuilder.contact(this.contact());

    return apiInfoBuilder;
  }

  @Bean
  public Docket detalheApi() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.hiagosouza.rest_api.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.apiInfos().build())
            .consumes(new HashSet<>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));

    return docket;
  }

}