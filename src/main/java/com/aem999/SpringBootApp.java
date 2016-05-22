package com.aem999;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Create a Spring Boot Application.
 */
@SpringBootApplication
public class SpringBootApp {

    private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

    /**
     * Start application.
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringBootApp.class)
                .run(args);
    }
}
