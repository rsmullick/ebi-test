package com.example.personresource.handler;

import com.example.personresource.domain.Person;
import com.example.personresource.service.PersonService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonRequestHandler {

    private PersonService personService;

    public PersonRequestHandler(PersonService personService) {
        this.personService = personService;
    }

    public Mono<ServerResponse> getAllPersons (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> updatePerson (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> createPerson (ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        Mono<Person> result = person.map(p -> {personService.createPerson(p);
            return p;
        });
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> deletePerson (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> getAllPersonByFirstName (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> getAllPersonByLastName (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }
    public Mono<ServerResponse> getAllPersonByAge (ServerRequest request) {
        Flux<Person> result = personService.getAllPersons();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(result, Person.class);
    }


}
