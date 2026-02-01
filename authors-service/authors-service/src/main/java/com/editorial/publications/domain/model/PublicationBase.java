package com.editorial.publications.domain.model;

import java.time.LocalDateTime;

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

    protected String title;

    protected String content;

    protected Long authorId;

    @Enumerated(EnumType.STRING)
    protected PublicationStatus status;

    protected LocalDateTime createdAt;

    protected PublicationBase() {
        this.createdAt = LocalDateTime.now();
        this.status = PublicationStatus.DRAFT;
    }

    // getters
}
