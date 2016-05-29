package com.aem999.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * {@link AuditorAware} component used to lookup the current principal.
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        // Will return the current user when security is in place
        return "Unknown";
    }
}
