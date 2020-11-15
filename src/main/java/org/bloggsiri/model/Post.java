package org.bloggsiri.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    @Column(name = "title")
    private String title;

    @JsonProperty("content")
    @Column(name = "content")
    private String content;

    @JsonProperty("creationDate")
    @Column(name = "creation_date")
    private LocalDate creationDate;
}
