package io.ayounsi.springbootangular.persistence.reactive;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@ComponentScan("io.ayounsi.springbootangular.persistence.reactive")
@EnableReactiveMongoRepositories(basePackages = "io.ayounsi.springbootangular.persistence.reactive")
public class ReactivePersistenceModuleConfiguration {
}
