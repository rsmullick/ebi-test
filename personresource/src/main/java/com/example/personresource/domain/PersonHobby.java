package com.example.personresource.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "HOBBY")
public class PersonHobby {
    @Id
    @GeneratedValue
    private Long id;
    private List<String> hobbies = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Hobby hobby;
}
