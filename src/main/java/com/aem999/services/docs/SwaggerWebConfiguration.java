package com.aem999.services.docs;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Remap default Swagger UI paths to '/api/docs'.
 */
@Component
public class SwaggerWebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/docs/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/api/docs/configuration/ui", "/configuration/ui");
        registry.addRedirectViewController("/api/docs/configuration/security", "/configuration/security");
        registry.addRedirectViewController("/api/docs/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/docs/**").addResourceLocations("classpath:/META-INF/resources/");
    }
}
