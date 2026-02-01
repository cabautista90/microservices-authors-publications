package com.editorial.authors.authors_service.authors.domain.model;

@Entity
@Table(name = "authors")
public class Author {

    @Column(nullable = false)
    private String biography;
}
