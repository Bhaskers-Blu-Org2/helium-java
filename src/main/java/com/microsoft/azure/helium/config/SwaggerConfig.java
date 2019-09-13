package com.microsoft.azure.helium.config;

import java.util.Collections;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {     

 /*    @Bean
   public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .useDefaultResponseMessages(false)
          .select()
            .apis(RequestHandlerSelectors.basePackage("com.microsoft.azure.helium"))
            .paths(regex("/api/.*"))
            .build()
          .apiInfo(apiInfo());                 
    }
*/

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }





    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Helium")
                .description("Java app for bootstrapping your next Web Apps for Containers service using Key Vault and Managed Identities")
                .version("1.0-SNAPSHOT")
                .build();
    }
}