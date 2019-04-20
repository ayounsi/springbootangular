package io.ayounsi.springbootangular.infra.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(name = "application.security.enabled", havingValue = "true", matchIfMissing = true)
@Import(SecurityModuleConfiguration.class)
public class SecurityModuleAutoConfiguration {
}
