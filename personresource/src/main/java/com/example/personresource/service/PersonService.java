package com.example.personresource.service;

import com.example.personresource.domain.Person;
import com.example.personresource.repository.PersonRepository;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private ReactiveCircuitBreakerFactory cbFactory;
    public PersonService(PersonRepository personRepository, ReactiveCircuitBreakerFactory cbFactory) {
        this.personRepository = personRepository;
        this.cbFactory = cbFactory;
    }

    public Flux<Person> getAllPersons() {
        return personRepository.findAll()
                .transform(it -> {
                    ReactiveCircuitBreaker cb = cbFactory.create("defaultCustomizer");
                    return cb.run(it, throwable ->
                            Flux.just(new Person(0l , "first", "last", 0, "data not found")));
                });
    }
}
