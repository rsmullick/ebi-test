package com.example.personresource.domain;


import lombok.AllArgsConstructor;
import lombok.Value;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
@NodeEntity
@Value(staticConstructor = "of")
public class Person {
    @Id @GeneratedValue
    private Long id;
     private String firstName;
     private String lastName;
     private Integer age;
    private String favourite_color;
    @Relationship(type = "HOBBY")
    private List<Hobby> hobby = new ArrayList();

    public Person(Long id, String firstName, String lastName, Integer age, String favourite_color) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.favourite_color = favourite_color;
    }
}
