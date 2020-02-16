package com.example.personresource.domain;


import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
@NodeEntity
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id @GeneratedValue
    private Long id;
     private String firstName;
     private String lastName;
     private Integer age;
    private String favourite_color;
    @Relationship(type = "HOBBY")
    private List<Hobby> hobby = new ArrayList();


}
