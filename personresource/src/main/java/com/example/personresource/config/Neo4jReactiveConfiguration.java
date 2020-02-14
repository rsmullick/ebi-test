package com.example.personresource.config;

import com.example.personresource.domain.Person;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.springframework.data.config.AbstractReactiveNeo4jConfig;
import org.neo4j.springframework.data.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableReactiveNeo4jRepositories
@EnableTransactionManagement
class Neo4jReactiveConfiguration extends AbstractReactiveNeo4jConfig {

    @Bean
    public Driver driver() {
        return GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "passphrase"));
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singletonList(Person.class.getPackage().getName());
    }
}