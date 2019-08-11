package io.ayounsi.springbootangular.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
@Validated
@ConfigurationProperties(prefix = "api")
public class ApiProperties {

    /**
     * base path for the api url
     */
    @NotNull
    @NotEmpty
    private String basePath;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
