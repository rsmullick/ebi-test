package com.example.personresource.repository;

import com.example.personresource.domain.Person;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveNeo4jRepository<Person, Long> {
}
