package com.aem999;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Create a Spring Boot Application.
 */
@SpringBootApplication
public class SpringBootApp {

    /**
     * Start application.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringBootApp.class)
                .run(args);
    }
}
