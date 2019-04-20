package io.ayounsi.springbootangular.persistence.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(PersistenceModuleConfiguration.class)
@Configuration
public @interface EnablePersistenceModule {
}