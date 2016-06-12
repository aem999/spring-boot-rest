package com.aem999.services.docs;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import com.google.common.base.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String API_TITLE = "Spring Boot Example API";
    private static final String API_VERSION = "1.0";
    private static final String API_DESCRIPTION = "RESTful API using Spring Boot";
    private static final Contact API_CONTACT = new Contact("https://github.com/aem999", "", "");

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(apiPaths())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private static Predicate<String> apiPaths() {
        return or(
                regex("/"),
                regex("/api.*")
        );
    }

    private static ApiInfo apiInfo() {
        return new ApiInfo(
                API_TITLE,
                API_DESCRIPTION,
                API_VERSION,
                "",
                API_CONTACT,
                "",
                ""
        );
    }

}
