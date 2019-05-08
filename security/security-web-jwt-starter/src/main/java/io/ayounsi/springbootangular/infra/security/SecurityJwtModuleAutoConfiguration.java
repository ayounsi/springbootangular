package io.ayounsi.springbootangular.infra.security;

import io.ayounsi.springbootangular.infra.security.config.JwtSecurityConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(name = "application.security.enabled", havingValue = "true", matchIfMissing = true)
@Import(JwtSecurityConfiguration.class)
public class SecurityJwtModuleAutoConfiguration {
}
