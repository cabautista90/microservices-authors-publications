package com.editorial.authors.authors_service.authors.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String biography;
    private LocalDateTime createdAt;

    protected Author() {
    }

    public Author(String name, String email, String biography, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.biography = biography;
        this.createdAt = createdAt;
    }

    // GETTERS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBiography() {
        return biography;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

