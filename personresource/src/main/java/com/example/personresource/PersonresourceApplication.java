package com.example.personresource;

import org.neo4j.springframework.data.repository.config.EnableReactiveNeo4jRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonresourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonresourceApplication.class, args);
    }

}
