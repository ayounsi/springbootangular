package io.ayounsi.springbootangular.persistence.reactive;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(ReactivePersistenceModuleConfiguration.class)
@Configuration
public @interface EnableReactivePersistenceModule {
}