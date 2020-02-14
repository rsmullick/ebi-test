package com.example.personresource.config;

import com.example.personresource.handler.PersonRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class PersonRequestRouter {
    @Bean
    public RouterFunction<ServerResponse> route(PersonRequestHandler personRequestHandler) {

        return RouterFunctions
                .route(GET("/allpersons").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::getAllPersons)
                .andRoute(GET("/allpersonbyfirstname").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::getAllPersonByFirstName)
                .andRoute(GET("/allpersonbylastname").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::getAllPersonByLastName)
                .andRoute(GET("/allpersonbyage").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::getAllPersonByAge)
                .andRoute(RequestPredicates.DELETE("/removeperson").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::deletePerson)
                .andRoute(RequestPredicates.POST("/addpersons").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::createPerson)
                .andRoute(RequestPredicates.PUT("/update").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), personRequestHandler::updatePerson)
                .and(notFound())
                ;
    }

    @Bean
    public RouterFunction<ServerResponse> notFound() {
        return RouterFunctions
                .route(GET("/statuses/not-found"),
                        request -> ServerResponse.notFound().build());
    }
}
