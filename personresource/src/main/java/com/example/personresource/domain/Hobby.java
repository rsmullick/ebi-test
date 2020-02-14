package com.example.personresource.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NonNull;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.List;

@NodeEntity
public class Hobby {
    @Id @GeneratedValue
    private Long id;

    @NonNull private String hobby;

    @JsonIgnoreProperties("hobby")
    @Relationship(type = "HOBBY", direction = Relationship.INCOMING)
    private List<Hobby> hobbies;
}
