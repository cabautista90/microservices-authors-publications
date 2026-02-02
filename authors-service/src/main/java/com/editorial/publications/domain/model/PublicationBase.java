package com.editorial.publications.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PublicationBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String title;

    @Column(nullable = false, length = 5000)
    protected String content;

    @Column(name = "author_id", nullable = false)
    protected Long authorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected PublicationStatus status;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    protected PublicationBase() {
        this.createdAt = LocalDateTime.now();
    }
}
