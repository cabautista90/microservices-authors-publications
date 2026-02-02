package com.editorial.authors.authors_service.authors.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuthorBase {

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(length = 1000)
    protected String biography;

    @Column(nullable = false)
    protected LocalDateTime createdAt;

    protected AuthorBase() {
    }

    // GETTERS
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
